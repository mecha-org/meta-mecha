inherit extrausers

USER = "mecha"

IMAGE_INSTALL:append = " sudo"

#IMAGE_ROOTFS_SIZE ?= "4192"

EXTRA_USERS_PARAMS = "\
    useradd -s /bin/zsh -p '\$5\$11223344\$Qi1UvJ46XO2CCaKoCyuMjV4cPu7YWZYWoSJpu3gdGsD' ${USER}; \
    usermod -aG video ${USER}; \
    usermod -aG sudo ${USER}; \
    usermod -aG render ${USER}; \
    usermod -aG input ${USER}; \ 
    useradd -M greeter; \
    usermod -aG video greeter; \
    usermod -aG render greeter; \
"

# do_install:append() {
#     install -d ${D}/home/mecha/
#     chown -R ${USER}:${USER} ${IMAGE_ROOTFS}/home/mecha
# }
#USERADD_PARAM:${PN} = "--home /home/weston --shell /bin/sh --user-group -G video,input weston"
# useradd -s /bin/zsh
#usermod -L -e 1 root; 
#passwd-expire ${USER}; 

enable_sudo_group() {
    echo "mecha ALL=(ALL:ALL) ALL" >> ${IMAGE_ROOTFS}/etc/sudoers
    echo "# Add /sbin PATH for mecha user" >> ${IMAGE_ROOTFS}/etc/profile
    echo "[ \"\$HOME\" != \"/home/mecha\" ] || PATH=\$PATH:/usr/local/sbin:/usr/sbin:/sbin:/bin" >> ${IMAGE_ROOTFS}/etc/profile
}
# chown -R mecha:mecha ${IMAGE_ROOTFS}/home/mecha
#    echo "[ "\$HOME" != "/home/mecha" ] || PATH=\$PATH:/usr/local/sbin:/usr/sbin:/sbin" >> ${IMAGE_ROOTFS}/etc/profile

# change_vpu_hantro_dma_buf_permisssion() {

#     chown -R video ${IMAGE_ROOTFS}/dev/dma_heap/linux,cma
#     chown -R video ${IMAGE_ROOTFS}/dev/dma_heap/linux,cma-uncached
#     chown -R video ${IMAGE_ROOTFS}/dev/dma_heap/system

#     chmod 660 ${IMAGE_ROOTFS}/dev/dma_heap/linux,cma
#     chmod 660 ${IMAGE_ROOTFS}/dev/dma_heap/linux,cma-uncached
#     chmod 660 ${IMAGE_ROOTFS}/dev/dma_heap/system

#     chown -R video ${IMAGE_ROOTFS}/dev/mxc_hantro
#     chown -R video ${IMAGE_ROOTFS}/dev/mxc_hantro_h1

#     chmod 660 ${IMAGE_ROOTFS}/dev/mxc_hantro
#     chmod 660 ${IMAGE_ROOTFS}/dev/mxc_hantro_h1
# }

ROOTFS_POSTPROCESS_COMMAND += "enable_sudo_group;"
#ROOTFS_POSTPROCESS_COMMAND += "change_vpu_hantro_dma_buf_permisssion;"


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
