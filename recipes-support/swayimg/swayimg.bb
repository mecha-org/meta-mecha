DESCRIPTION = "swayimg"
SECTION = "Mywork"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = "git://github.com/artemsen/swayimg;branch=master;protocol=https"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

DEPENDS = " wayland wayland-native wayland-protocols json-c libxkbcommon fontconfig"

RDEPENDS:${PN} += " pkgconfig"

inherit cmake meson pkgconfig 

FILES:${PN} += "/usr/share/*"

