inherit extrausers

USER = "mecha"

IMAGE_INSTALL:append = " sudo"

#IMAGE_ROOTFS_SIZE ?= "4192"

EXTRA_USERS_PARAMS = "\
    useradd -p '\$5\$11223344\$Qi1UvJ46XO2CCaKoCyuMjV4cPu7YWZYWoSJpu3gdGsD' ${USER}; \
    usermod -aG video ${USER}; \
    usermod -aG sudo ${USER}; \
    usermod -aG render ${USER}; \
    usermod -aG input ${USER}; \ 
"

#usermod -L -e 1 root; 
#passwd-expire ${USER}; 

enable_sudo_group() {
    echo "mecha ALL=(ALL:ALL) ALL" >> ${IMAGE_ROOTFS}/etc/sudoers
}
ROOTFS_POSTPROCESS_COMMAND += "enable_sudo_group;"


#do_install() {
#         install -d ${D}/home
#         install -m -r 0755 media-files ${D}/home
#}

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

# ${IMAGE_ROOTFS} = /tmp/work/imx8mmlpddr4evk-poky-linux/imx-image-multimedia/1.0-r0/rootfs
