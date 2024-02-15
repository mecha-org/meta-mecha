# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the basic core image with minimal tests"

inherit core-image

IMAGE_FEATURES += " \
    tools-profile \
    tools-sdk \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-dropbear \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston','', d)} \
"

SDKIMAGE_FEATURES:append = " \
    staticdev-pkgs \
"

IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    imx-test \
    firmwared \
    packagegroup-imx-core-tools \
    packagegroup-imx-security \
    curl \
    ${CLINFO} \
    ${DOCKER} \
"

#IMAGE_INSTALL:remove = " coreutils"
CLINFO              ?= ""
CLINFO:imxgpu        = "clinfo"
CLINFO:mx8mm-nxp-bsp = ""
CLINFO:mx7-nxp-bsp   = ""

DOCKER            ?= ""
DOCKER:mx8-nxp-bsp = "docker"

export IMAGE_BASENAME = "mecha-image-core"

#-----------------------------------------------------------------------------------

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-audio \
    packagegroup-fsl-pulseaudio \
    packagegroup-core-weston \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
"

# Enable package-management
#EXTRA_IMAGE_FEATURES += "package-management"

IMAGE_INSTALL:append = " connman connman-client" 
IMAGE_INSTALL:append = " ntp"
NTP_SERVERS = "time.google.com time1.google.com"

IMAGE_INSTALL:append = " mesa mesa-demos"     
IMAGE_INSTALL:append = " bluez5"     
IMAGE_INSTALL:append = " dpkg"
IMAGE_INSTALL:append = " git"
# IMAGE_INSTALL:append = " easysplash"     
# IMAGE_INSTALL:append = " easysplash-bootanimation-lafon"     
IMAGE_INSTALL:append = " easysplash easysplash-bootanimation-mecha"     


# poky/meta/recipes-graphics/xorg-app/
IMAGE_INSTALL:append = " xhost xauth sysbench htop"

# Dhruveh
#IMAGE_INSTALL:append = " mecha-device-test"

IMAGE_INSTALL:append = " cage"
IMAGE_INSTALL:append = " phoc"
#IMAGE_INSTALL:append = " sway-18 sway-login-configs"
IMAGE_INSTALL:append = " sway sway-login-configs libpam-pwdfile"
# IMAGE_INSTALL:append = " way-vnc neatvnc"
IMAGE_INSTALL:append = " greetd wlgreet dlm gtkgreet"
IMAGE_INSTALL:append = " gtk4"
IMAGE_INSTALL:append = " zsh"
IMAGE_INSTALL:append = " foot"
IMAGE_INSTALL:append = " tzdata"



# Media files to test audio-video & photos
IMAGE_INSTALL:append = " test-files"

#IMAGE_INSTALL:append = " wpewebkit cog"
#IMAGE_INSTALL:append = " chromium-ozone-wayland"

#--------------------------------------------------------------------------------------

IMAGE_INSTALL:append = " swaylock swayidle swaybg"
IMAGE_INSTALL:append = " waybar rot8"
IMAGE_INSTALL:append = " nwg-drawer"
IMAGE_INSTALL:append = " nwg-dock"

