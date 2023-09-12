DESCRIPTION = "aml"
SECTION = "Mywork"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#inherit pkgconfig

SRC_URI = "git://github.com/any1/aml;branch=master;protocol=https"

S = "${WORKDIR}/git"

SRCREV = "ede424968e9e521c6e058be48d3ac89e8c9d700b"

#DEPENDS = " openssl"
#do_configure[noexec] = "1"
#TARGET_CC_ARCH += "${LDFLAGS}"

DEPENDS = " pkgconfig pkgconfig-native \ 
    wayland \
    wayland-protocols \
    wayland-native \
    wayland-utils \
    libxkbcommon \
    drm \
    libxkbcommon \
    pixman \
    jansson \
"

#CFLAGS = "--sysroot=${SDKTARGETSYSROOT} -mfloat-abi=hard"

#do_compile() {
#        oe_runmake -C ${S}
#}

#do_compile() {
#         ${CC} led_blink_06.c -o led_blink_06
#}

#do_install() {
#         install -d ${D}${bindir}
#         install -m 0755 led_blink_06 ${D}${bindir}
#}

inherit meson 

PACKAGES += "${PN}-systemd"

FILES:${PN}-systemd += "${libdir}/systemd"