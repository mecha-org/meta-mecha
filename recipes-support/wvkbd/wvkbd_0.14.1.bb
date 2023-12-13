DESCRIPTION = "wvkbd - Onscreen Keyboard for Wayland (wlroots)"
SECTION = "support"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pkgconfig

SRC_URI = "git://github.com/jjsullivan5196/wvkbd;branch=master;protocol=https"

S = "${WORKDIR}/git"

SRCREV = "aaff22a1054a7ca7e4237c723fc5f99c1d36f608"
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