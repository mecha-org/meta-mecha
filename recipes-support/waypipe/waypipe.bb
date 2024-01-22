DESCRIPTION = "waypipe"
SECTION = "Mywork"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = "git://gitlab.freedesktop.org/mstoeckl/waypipe;branch=master;protocol=https"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

inherit cmake meson   

# remove PSEUDO path mismatch error
PACKAGE_DEBUG_SPLIT_STYLE = "debug-without-src"

do_install() {
         install -d ${D}${bindir}
         install -m 0755 ${WORKDIR}/build/src/waypipe ${D}${bindir}
}
