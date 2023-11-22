DESCRIPTION = "wvkbd - Onscreen Keyboard for Wayland (wlroots)"
SECTION = "support"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pkgconfig

SRC_URI = "git://github.com/jjsullivan5196/wvkbd;branch=master;protocol=https"

S = "${WORKDIR}/git"

SRCREV = "927918ccc541c8c39bab8a37ec46e0add052b229"
PV = "0.14.3"

TARGET_CC_ARCH += "${LDFLAGS}"

DEPENDS += " pango cairo wayland wayland-native wayland-protocols-native libxkbcommon"

do_compile() {
        oe_runmake -C ${S}
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${S}/wvkbd-mobintl ${D}${bindir}
}