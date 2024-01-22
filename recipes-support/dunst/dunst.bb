DESCRIPTION = "Dunst"
HOMEPAGE = "https://github.com/dunst-project/dunst"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = "git://github.com/dunst-project/dunst;branch=master;protocol=https"

S = "${WORKDIR}/git"

SRCREV = "dfab9f057f89702ade5725c8247a520ab51026f4"

inherit pkgconfig 

RDEPENDS:${PN} = "dbus"
DEPENDS = " wayland wayland-protocols xdg-utils pango cairo gdk-pixbuf libnotify libxinerama libxscrnsaver perl-native"

do_compile() {
    oe_runmake -C ${S} all
}

# remove PSEUDO path mismatch error
# PACKAGE_DEBUG_SPLIT_STYLE = "debug-without-src"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/dunst ${D}${bindir}
    install -m 0755 ${S}/dunstctl ${D}${bindir}
    install -m 0755 ${S}/dunstify ${D}${bindir}
}
