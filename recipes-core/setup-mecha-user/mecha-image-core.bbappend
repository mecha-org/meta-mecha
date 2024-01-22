inherit extrausers

USER = "mecha"

IMAGE_INSTALL:append = " sudo"

# IMAGE_ROOTFS_SIZE ?= "8384"
# IMAGE_ROOTFS_EXTRA_SPACE:append = " + 8384"

EXTRA_USERS_PARAMS = "\
    useradd -u 1001 -p '\$5\$11223344\$Qi1UvJ46XO2CCaKoCyuMjV4cPu7YWZYWoSJpu3gdGsD' ${USER}; \
    usermod -aG video ${USER}; \
    usermod -aG sudo ${USER}; \
    usermod -aG render ${USER}; \
    usermod -aG input ${USER}; \ 
    usermod -L -e 1 root; \
    passwd-expire ${USER}; \
    useradd -M greeter; \
    usermod -aG video greeter; \
    usermod -aG render greeter; \
"


# Disable root login and force user for new password at first login
# usermod -L -e 1 root; 
# passwd-expire ${USER}; 

# Enable ZSH shell by default -s /bin/zsh
# useradd -s /bin/zsh -u 1001 -p '\$5\$11223344\$Qi1UvJ46XO2CCaKoCyuMjV4cPu7YWZYWoSJpu3gdGsD' ${USER}; 

enable_sudo_group() {
    echo "mecha ALL=(ALL:ALL) ALL" >> ${IMAGE_ROOTFS}/etc/sudoers
    echo "# Add /sbin PATH for mecha user" >> ${IMAGE_ROOTFS}/etc/profile
    echo "[ \"\$HOME\" != \"/home/mecha\" ] || PATH=\$PATH:/usr/local/sbin:/usr/sbin:/sbin:/bin" >> ${IMAGE_ROOTFS}/etc/profile
}

enable_separate_home_partition() {
    echo "/dev/mmcblk2p3   /home   ext4   errors=remount-ro  0  2"  >>  ${IMAGE_ROOTFS}/etc/fstab
}

enable_watchdog(){
    echo "RuntimeWatchdogSec=30sec"  >>  ${IMAGE_ROOTFS}/etc/systemd/system.conf
    echo "RebootWatchdogSec=60sec"  >>  ${IMAGE_ROOTFS}/etc/systemd/system.conf
}

enable_systemd_user(){
    install -m 0755 -o 1001 -g 1001 -d ${IMAGE_ROOTFS}/home/mecha/.config/systemd/user/default.target.wants
    install -m 0755 -o 1001 -g 1001 -d ${IMAGE_ROOTFS}/home/mecha/.config/systemd/user/sockets.target.wants
}

symlink_pulseaudio_service(){
    ln -s ${systemd_user_unitdir}/pulseaudio.service ${IMAGE_ROOTFS}/home/mecha/.config/systemd/user/default.target.wants/pulseaudio.service
    ln -s ${systemd_user_unitdir}/pulseaudio.socket ${IMAGE_ROOTFS}/home/mecha/.config/systemd/user/sockets.target.wants/pulseaudio.socket
    chown -R 1001:1001 ${IMAGE_ROOTFS}/home/mecha
}

copy_boot_logo_to_boot_part(){
	cp  ${THISDIR}/files/logo.bmp  ${IMAGE_ROOTFS}/boot
	cp  ${THISDIR}/files/low_battery.bmp  ${IMAGE_ROOTFS}/boot
}

ROOTFS_POSTPROCESS_COMMAND +=  "enable_sudo_group; \
                                enable_separate_home_partition; \
                                enable_watchdog; enable_systemd_user; \
                                symlink_pulseaudio_service; \
                                copy_boot_logo_to_boot_part; \
                                "



# Tow files to enable fw_printenv command in userspace
# /mecha_comet_m_gen1-poky-linux/u-boot-imx/2023.04-r0/build/imx8mm_evk_defconfig/u-boot-initial-env
# fw_env.config contains values of CONFIG_ENV_SIZE=0x4000
# 								   CONFIG_ENV_OFFSET=0x700000


# echo "export PATH=\"/usr/local/sbin:\$PATH\"" > ${IMAGE_ROOTFS}/home/mecha/.zshrc
# echo "export PATH=\"/usr/sbin:\$PATH\"" >> ${IMAGE_ROOTFS}/home/mecha/.zshrc
# echo "export PATH=\"/sbin:\$PATH\"" >> ${IMAGE_ROOTFS}/home/mecha/.zshrc
# echo "export PATH=\"/bin:\$PATH\"" >> ${IMAGE_ROOTFS}/home/mecha/.zshrc


# do_install:append() {
#     install -d ${D}/home/mecha
#     install -m 0775 ${WORKDIR}/.zshrc ${D}/home/mecha/.zshrc
#     chown -R 1001:1001 ${D}/home/mecha/
# }

#FILES:${PN} += "/home/mecha/.zshrc"


#    usermod -L -e 1 root; 
#    usermod -p 'openssl passwd ${ROOTPASS}' root; 
#    useradd -p `openssl passwd ${PASSWORD}` ${USER}; 

#    usermod -L -e 1 root; 
#    passwd-expire ${USER};  DISABLE ROOT LOGING on FIRST BOOT

#======================== Create Password =========================

#    mkpasswd -m sha-256 technexion -s "11223344"
#    mkpasswd -m sha-512 technexion -s "11223344"
#    mkpasswd -m sha256crypt technexion -s "11223344"
#    mkpasswd -m sha-256 mecha -s "11223344"
#    $5$11223344$Qi1UvJ46XO2CCaKoCyuMjV4cPu7YWZYWoSJpu3gdGsD

#===================================================================

#    echo mecha | sudo -S echo "mecha ALL=(ALL:ALL) ALL" >> ${IMAGE_ROOTFS}/etc/sudoers
#    sudo touch ${IMAGE_ROOTFS}/etc/default/weston
#    echo "HOME=/home/mecha/" > ${IMAGE_ROOTFS}/etc/default/weston
#    sudo touch ${IMAGE_ROOTFS}/etc/udev/rules.d/71-weston-drm.rules
#    echo "ACTION==\"add\", SUBSYSTEM==\"graphics\", KERNEL==\"fb0\", TAG+=\"systemd\", ENV{SYSTEMD_WANTS}+=\"weston@mecha.service\"" >> ${IMAGE_ROOTFS}/etc/udev/rules.d/71-weston-drm.rules
#    echo "ACTION==\"add\", SUBSYSTEM==\"drm\", KERNEL==\"card0\", TAG+=\"systemd\", ENV{SYSTEMD_WANTS}+=\"weston@mecha.service\"" >> ${IMAGE_ROOTFS}/etc/udev/rules.d/71-weston-drm.rules

#    echo "ACTION==\"add\", SUBSYSTEM==\"graphics\", KERNEL==\"fb0\", TAG+=\"systemd\", ENV{SYSTEMD_WANTS}+=\"weston@mecha.service\"" >> ${IMAGE_ROOTFS}/etc/udev/rules.d/71-weston-drm.rules
#    echo "ACTION==\"add\", SUBSYSTEM==\"drm\", KERNEL==\"card0\", TAG+=\"systemd\", ENV{SYSTEMD_WANTS}+=\"weston@mecha.service\"" >> ${IMAGE_ROOTFS}/etc/udev/rules.d/71-weston-drm.rules
