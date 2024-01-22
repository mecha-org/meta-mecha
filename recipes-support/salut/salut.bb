SUMMARY = "salut"
HOMEPAGE = "https://gitlab.com/snakedye/salut"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://gitlab.com/snakedye/salut.git;protocol=https;branch=master"
SRCREV="aa57c4d190812908a9c32cd49cff14390c6dfdcb"

S = "${WORKDIR}/git"

DEPENDS:append = " fontconfig fontconfig-native libx11 libxkbcommon xcb-util"