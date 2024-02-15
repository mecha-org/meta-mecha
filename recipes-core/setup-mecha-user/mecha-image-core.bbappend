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

# Enable ZSH shell by default -s /bin/zsh
# useradd -s /bin/zsh -u 1001 -p '\$5\$11223344\$Qi1UvJ46XO2CCaKoCyuMjV4cPu7YWZYWoSJpu3gdGsD' ${USER}; 

enable_sudo_group() {
    echo "mecha ALL=(ALL:ALL) ALL" >> ${IMAGE_ROOTFS}/etc/sudoers
    echo "# Add /sbin PATH for mecha user" >> ${IMAGE_ROOTFS}/etc/profile
    echo "[ \"\$HOME\" != \"/home/mecha\" ] || PATH=\$PATH:/usr/local/sbin:/usr/sbin:/sbin:/bin" >> ${IMAGE_ROOTFS}/etc/profile
}

enable_separate_boot_partition() {
    echo "/dev/mmcblk2p1   /boot   vfat   errors=remount-ro  0  2"  >>  ${IMAGE_ROOTFS}/etc/fstab
}

# To enable separate home parttion
# echo "/dev/mmcblk2p3   /home   ext4   errors=remount-ro  0  2"  >>  ${IMAGE_ROOTFS}/etc/fstab

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


ROOTFS_POSTPROCESS_COMMAND +=  "enable_sudo_group; \
                                enable_separate_boot_partition; \
                                enable_watchdog; enable_systemd_user; \
                                symlink_pulseaudio_service; \
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


#============DISABLE ROOT LOGING on FIRST BOOT and ================
#              force user for new password at first login
#    usermod -L -e 1 root; 
#    passwd-expire ${USER};  

#======================== Create Password =========================

#    mkpasswd -m sha-256 technexion -s "11223344"
#    mkpasswd -m sha-512 technexion -s "11223344"
#    mkpasswd -m sha256crypt technexion -s "11223344"
#    mkpasswd -m sha-256 mecha -s "11223344"
#    $5$11223344$Qi1UvJ46XO2CCaKoCyuMjV4cPu7YWZYWoSJpu3gdGsD

#==================================================================

