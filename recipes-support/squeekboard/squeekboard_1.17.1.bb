SUMMARY = "A Wayland virtual keyboard"
DESCRIPTION = "Squeekboard is a virtual keyboard supporting Wayland, built \
primarily for the Librem 5 phone. \
It squeaks because some Rust got inside."
HOMEPAGE = "https://developer.puri.sm/projects/squeekboard/"
BUGTRACKER = "https://gitlab.gnome.org/World/Phosh/squeekboard/-/issues"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://debian/copyright;md5=03d0c6e3f2e8ec62fb33c983433ce7e5"

DEPENDS = "\
    feedbackd \
    glib-2.0 \
    glib-2.0-native \
    gnome-desktop \
    gtk+3 \
    libxkbcommon \
    wayland \
    wayland-native \
    wayland-protocols \
    rust-bin-cross-aarch64 \
    "

SRC_URI = "\
    git://gitlab.gnome.org/World/Phosh/squeekboard.git;protocol=https;branch=${BRANCH} \
    git://source.puri.sm/dorota.czaplejewicz/fragile.git;protocol=https;nobranch=1;name=fragile;destsuffix=fragile \
    file://0001-Pass-additional-arguments-to-cargo.patch \
    file://0001-Skip-build-tests-if-not-enabled.patch \
    "

# Modify these as desired
PV = "1.17.1"
SRCREV = "2faa98d85f1142383ec8ad1487616c1a7ad1882f"
BRANCH = "1.17"

SRCREV_FORMAT .= "_fragile"
SRCREV_fragile = "51048ca11824279c2114c77fef5bcb950838fc09"
EXTRA_OECARGO_PATHS += "${WORKDIR}/fragile"

S = "${WORKDIR}/git"
do_compile[network] = "1"
inherit cargo_bin rust_bin-common meson pkgconfig

EXTRA_OEMESON = "\
    -Dcargo-flags=[\'--target\',\'${HOST_SYS}\',\'-v\'] \
    -Dtests=false \
    -Ddepdatadir=${datadir} \
    -Donline=true \
"

export CARGO_FEATURE_STD = "1"

do_compile[network] = "1"

do_configure() {
    cargo_bin_do_configure
    export RUSTFLAGS="${RUSTFLAGS}"
    export RUST_TARGET_PATH="${RUST_TARGET_PATH}"
    meson_do_configure
}

do_compile() {
    oe_cargo_fix_env
    export RUSTFLAGS="${RUSTFLAGS}"
    export RUST_TARGET_PATH="${RUST_TARGET_PATH}"
    meson_do_compile
}

do_install() {
    oe_cargo_fix_env
    export RUSTFLAGS="${RUSTFLAGS}"
    export RUST_TARGET_PATH="${RUST_TARGET_PATH}"
    meson_do_install

    install -d ${D}${sysconfdir}/xdg/autostart
    cp ${D}${datadir}/applications/sm.puri.Squeekboard.desktop ${D}${sysconfdir}/xdg/autostart
}
