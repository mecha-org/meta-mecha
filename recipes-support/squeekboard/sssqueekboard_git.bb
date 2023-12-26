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
    "

# Modify these as desired
PV = "1.19.0"
SRCREV = "9f4c5e2264404c6caf1a6e2ca708d090806487ea"

S = "${WORKDIR}/git"

inherit cargo_bin meson pkgconfig

EXTRA_OEMESON = "\
    -Dcargo-flags=[\'--target\',\'${HOST_SYS}\',\'-v\'] \
    -Dtests=false \
    -Ddepdatadir=${datadir} \
    -Donline=false \
    -Dnewer=true \
"

do_compile[network] = "1"
export CARGO_FEATURE_STD = "1"

do_configure() {
    cargo_common_do_configure
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
