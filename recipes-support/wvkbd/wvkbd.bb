DESCRIPTION = "wvkbd"
SECTION = "Mywork"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pkgconfig

SRC_URI = "git://github.com/shoaibmerchant/wvkbd;branch=master;protocol=https"

S = "${WORKDIR}/git"

SRCREV = "c319ad47e583206010c1d5e0cece83dd9b748264"

DEPENDS = " openssl"
do_configure[noexec] = "1"
TARGET_CC_ARCH += "${LDFLAGS}"

DEPENDS:append = "  pkgconfig pkgconfig-native wlroots wayland wayland-protocols wayland-native wayland-utils waylandpp libxkbcommon pango"

#CFLAGS = "--sysroot=${SDKTARGETSYSROOT} -mfloat-abi=hard"

do_compile() {
        oe_runmake -C ${S}
}

#do_compile() {
#         ${CC} led_blink_06.c -o led_blink_06
#}

#do_install() {
#         install -d ${D}${bindir}
#         install -m 0755 led_blink_06 ${D}${bindir}
#}
