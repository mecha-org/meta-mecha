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
    gnome-desktop \
    gtk+3 \
    libxkbcommon \
    wayland \
    wayland-native \
    wayland-protocols \
    pkgconfig \
    cairo \
    pango \
    harfbuzz \
    libbsd \
    atk \
"
SRC_URI = "\
    git://gitlab.gnome.org/World/Phosh/squeekboard.git;protocol=https;nobranch=1 \
    git://source.puri.sm/dorota.czaplejewicz/fragile.git;protocol=https;nobranch=1;name=fragile;destsuffix=fragile \
    file://0001-Pass-additional-arguments-to-cargo.patch \
    file://0003-Skip-build-tests-if-not-enabled.patch \
    crate://crates.io/atk/0.7.0 \
    crate://crates.io/atk-sys/0.9.1 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/bitflags/1.2.1  \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/cairo-rs/0.7.1  \
    crate://crates.io/cairo-sys-rs/0.9.2  \
    crate://crates.io/cc/1.0.79 \
    crate://crates.io/cfg-if/0.1.10 \
    crate://crates.io/cfg-if/1.0.0  \
    crate://crates.io/clap/2.33.4 \
    crate://crates.io/derivative/2.2.0  \
    crate://crates.io/enumflags2/0.6.4  \
    crate://crates.io/enumflags2_derive/0.6.4 \
    crate://crates.io/fastrand/1.9.0  \
    crate://crates.io/fragile/0.3.0 \
    crate://crates.io/gdk/0.11.0  \
    crate://crates.io/gdk-pixbuf/0.7.0  \
    crate://crates.io/gdk-pixbuf-sys/0.9.1  \
    crate://crates.io/gdk-sys/0.9.1 \
    crate://crates.io/gio/0.7.0 \
    crate://crates.io/gio-sys/0.9.1 \
    crate://crates.io/glib/0.8.2  \
    crate://crates.io/glib-sys/0.9.1  \
    crate://crates.io/gobject-sys/0.9.1 \
    crate://crates.io/gtk/0.7.0 \
    crate://crates.io/gtk-sys/0.9.2 \
    crate://crates.io/hashbrown/0.12.3  \
    crate://crates.io/indexmap/1.9.3  \
    crate://crates.io/instant/0.1.12  \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/libc/0.2.140  \
    crate://crates.io/linked-hash-map/0.5.6 \
    crate://crates.io/maplit/1.0.2  \
    crate://crates.io/memmap/0.7.0  \
    crate://crates.io/nix/0.17.0  \
    crate://crates.io/pango/0.7.0 \
    crate://crates.io/pango-sys/0.9.1 \
    crate://crates.io/pkg-config/0.3.26 \
    crate://crates.io/proc-macro-crate/0.1.5  \
    crate://crates.io/proc-macro2/1.0.54  \
    crate://crates.io/quote/1.0.26  \
    crate://crates.io/ryu/1.0.13  \
    crate://crates.io/scoped-tls/1.0.1  \
    crate://crates.io/serde/1.0.159 \
    crate://crates.io/serde_derive/1.0.159  \
    crate://crates.io/serde_repr/0.1.12 \
    crate://crates.io/serde_yaml/0.8.26 \
    crate://crates.io/syn/1.0.109 \
    crate://crates.io/syn/2.0.12  \
    crate://crates.io/textwrap/0.11.0 \
    crate://crates.io/toml/0.5.11 \
    crate://crates.io/unicode-ident/1.0.8 \
    crate://crates.io/unicode-width/0.1.10  \
    crate://crates.io/void/1.0.2  \
    crate://crates.io/winapi/0.3.9  \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0  \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0  \
    crate://crates.io/xkbcommon/0.4.1 \
    crate://crates.io/yaml-rust/0.4.5 \
    crate://crates.io/zbus/1.0.0  \
    crate://crates.io/zbus_macros/1.0.0 \
    crate://crates.io/zvariant/2.0.1  \
    crate://crates.io/zvariant_derive/2.0.0 \
    "

SRC_URI[atk-0.7.0.sha256sum] = "86b7499272acf036bb5820c6e346bbfb5acc5dceb104bc2c4fd7e6e33dfcde6a"
SRC_URI[atk-sys-0.9.1.sha256sum] = "e552c1776737a4c80110d06b36d099f47c727335f9aaa5d942a72b6863a8ec6f"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[bitflags-1.2.1.sha256sum] = "cf1de2fe8c75bc145a2f577add951f8134889b4795d47466a54a5c846d691693"
SRC_URI[byteorder-1.4.3.sha256sum] = "14c189c53d098945499cdfa7ecc63567cf3886b3332b312a5b4585d8d3a6a610"
SRC_URI[cairo-rs-0.7.1.sha256sum] = "e05db47de3b0f09a222fa4bba2eab957d920d4243962a86b2d77ab401e4a359c"
SRC_URI[cairo-sys-rs-0.9.2.sha256sum] = "ff65ba02cac715be836f63429ab00a767d48336efc5497c5637afb53b4f14d63"
SRC_URI[cc-1.0.79.sha256sum] = "50d30906286121d95be3d479533b458f87493b30a4b5f79a607db8f5d11aa91f"
SRC_URI[cfg-if-0.1.10.sha256sum] = "4785bdd1c96b2a846b2bd7cc02e86b6b3dbf14e7e53446c4f54c92a361040822"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[clap-2.33.4.sha256sum] = "826bf7bc84f9435630275cb8e802a4a0ec792b615969934bd16d42ffed10f207"
SRC_URI[derivative-2.2.0.sha256sum] = "fcc3dd5e9e9c0b295d6e1e4d811fb6f157d5ffd784b8d202fc62eac8035a770b"
SRC_URI[enumflags2-0.6.4.sha256sum] = "83c8d82922337cd23a15f88b70d8e4ef5f11da38dd7cdb55e84dd5de99695da0"
SRC_URI[enumflags2_derive-0.6.4.sha256sum] = "946ee94e3dbf58fdd324f9ce245c7b238d46a66f00e86a020b71996349e46cce"
SRC_URI[fastrand-1.9.0.sha256sum] = "e51093e27b0797c359783294ca4f0a911c270184cb10f85783b118614a1501be"
SRC_URI[fragile-0.3.0.sha256sum] = "05f8140122fa0d5dcb9fc8627cfce2b37cc1500f752636d46ea28bc26785c2f9"
SRC_URI[gdk-0.11.0.sha256sum] = "6243e995f41f3a61a31847e54cc719edce93dd9140c89dca3b9919be1cfe22d5"
SRC_URI[gdk-pixbuf-0.7.0.sha256sum] = "9726408ee1bbada83094326a99b9c68fea275f9dbb515de242a69e72051f4fcc"
SRC_URI[gdk-pixbuf-sys-0.9.1.sha256sum] = "d8991b060a9e9161bafd09bf4a202e6fd404f5b4dd1a08d53a1e84256fb34ab0"
SRC_URI[gdk-sys-0.9.1.sha256sum] = "6adf679e91d1bff0c06860287f80403e7db54c2d2424dce0a470023b56c88fbb"
SRC_URI[gio-0.7.0.sha256sum] = "6261b5d34c30c2d59f879e643704cf54cb44731f3a2038000b68790c03e360e3"
SRC_URI[gio-sys-0.9.1.sha256sum] = "4fad225242b9eae7ec8a063bb86974aca56885014672375e5775dc0ea3533911"
SRC_URI[glib-0.8.2.sha256sum] = "be27232841baa43e0fd5ae003f7941925735b2f733a336dc75f07b9eff415e7b"
SRC_URI[glib-sys-0.9.1.sha256sum] = "95856f3802f446c05feffa5e24859fe6a183a7cb849c8449afc35c86b1e316e2"
SRC_URI[gobject-sys-0.9.1.sha256sum] = "31d1a804f62034eccf370006ccaef3708a71c31d561fee88564abe71177553d9"
SRC_URI[gtk-0.7.0.sha256sum] = "709f1074259d4685b96133f92b75c7f35b504715b0fcdc96ec95de2607296a60"
SRC_URI[gtk-sys-0.9.2.sha256sum] = "53def660c7b48b00b510c81ef2d2fbd3c570f1527081d8d7947f471513e1a4c1"
SRC_URI[hashbrown-0.12.3.sha256sum] = "8a9ee70c43aaf417c914396645a0fa852624801b24ebb7ae78fe8272889ac888"
SRC_URI[indexmap-1.9.3.sha256sum] = "bd070e393353796e801d209ad339e89596eb4c8d430d18ede6a1cced8fafbd99"
SRC_URI[instant-0.1.12.sha256sum] = "7a5bbe824c507c5da5956355e86a746d82e0e1464f65d862cc5e71da70e94b2c"
SRC_URI[lazy_static-1.4.0.sha256sum] = "e2abad23fbc42b3700f2f279844dc832adb2b2eb069b2df918f455c4e18cc646"
SRC_URI[libc-0.2.140.sha256sum] = "99227334921fae1a979cf0bfdfcc6b3e5ce376ef57e16fb6fb3ea2ed6095f80c"
SRC_URI[linked-hash-map-0.5.6.sha256sum] = "0717cef1bc8b636c6e1c1bbdefc09e6322da8a9321966e8928ef80d20f7f770f"
SRC_URI[maplit-1.0.2.sha256sum] = "3e2e65a1a2e43cfcb47a895c4c8b10d1f4a61097f9f254f183aee60cad9c651d"
SRC_URI[memmap-0.7.0.sha256sum] = "6585fd95e7bb50d6cc31e20d4cf9afb4e2ba16c5846fc76793f11218da9c475b"
SRC_URI[nix-0.17.0.sha256sum] = "50e4785f2c3b7589a0d0c1dd60285e1188adac4006e8abd6dd578e1567027363"
SRC_URI[pango-0.7.0.sha256sum] = "393fa071b144f8ffb83ede273758983cf414ca3c0b1d2a5a9ce325b3ba3dd786"
SRC_URI[pango-sys-0.9.1.sha256sum] = "86b93d84907b3cf0819bff8f13598ba72843bee579d5ebc2502e4b0367b4be7d"
SRC_URI[pkg-config-0.3.26.sha256sum] = "6ac9a59f73473f1b8d852421e59e64809f025994837ef743615c6d0c5b305160"
SRC_URI[proc-macro-crate-0.1.5.sha256sum] = "1d6ea3c4595b96363c13943497db34af4460fb474a95c43f4446ad341b8c9785"
SRC_URI[proc-macro2-1.0.54.sha256sum] = "e472a104799c74b514a57226160104aa483546de37e839ec50e3c2e41dd87534"
SRC_URI[quote-1.0.26.sha256sum] = "4424af4bf778aae2051a77b60283332f386554255d722233d09fbfc7e30da2fc"
SRC_URI[ryu-1.0.13.sha256sum] = "f91339c0467de62360649f8d3e185ca8de4224ff281f66000de5eb2a77a79041"
SRC_URI[scoped-tls-1.0.1.sha256sum] = "e1cf6437eb19a8f4a6cc0f7dca544973b0b78843adbfeb3683d1a94a0024a294"
SRC_URI[serde-1.0.159.sha256sum] = "3c04e8343c3daeec41f58990b9d77068df31209f2af111e059e9fe9646693065"
SRC_URI[serde_derive-1.0.159.sha256sum] = "4c614d17805b093df4b147b51339e7e44bf05ef59fba1e45d83500bcfb4d8585"
SRC_URI[serde_repr-0.1.12.sha256sum] = "bcec881020c684085e55a25f7fd888954d56609ef363479dc5a1305eb0d40cab"
SRC_URI[serde_yaml-0.8.26.sha256sum] = "578a7433b776b56a35785ed5ce9a7e777ac0598aac5a6dd1b4b18a307c7fc71b"
SRC_URI[syn-1.0.109.sha256sum] = "72b64191b275b66ffe2469e8af2c1cfe3bafa67b529ead792a6d0160888b4237"
SRC_URI[syn-2.0.12.sha256sum] = "79d9531f94112cfc3e4c8f5f02cb2b58f72c97b7efd85f70203cc6d8efda5927"
SRC_URI[textwrap-0.11.0.sha256sum] = "d326610f408c7a4eb6f51c37c330e496b08506c9457c9d34287ecc38809fb060"
SRC_URI[toml-0.5.11.sha256sum] = "f4f7f0dd8d50a853a531c426359045b1998f04219d88799810762cd4ad314234"
SRC_URI[unicode-ident-1.0.8.sha256sum] = "e5464a87b239f13a63a501f2701565754bae92d243d4bb7eb12f6d57d2269bf4"
SRC_URI[unicode-width-0.1.10.sha256sum] = "c0edd1e5b14653f783770bce4a4dabb4a5108a5370a5f5d8cfe8710c361f6c8b"
SRC_URI[void-1.0.2.sha256sum] = "6a02e4885ed3bc0f2de90ea6dd45ebcbb66dacffe03547fadbb0eeae2770887d"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[xkbcommon-0.4.1.sha256sum] = "032ed00cc755c31221bbd6aaf9fa4196a01bf33bca185f9316e14f26d28c28cf"
SRC_URI[yaml-rust-0.4.5.sha256sum] = "56c1936c4cc7a1c9ab21a1ebb602eb942ba868cbd44a99cb7cdc5892335e1c85"
SRC_URI[zbus-1.0.0.sha256sum] = "1cb97c72cbfd5c7537ca730eeb810da7348f345ba67ab7673bcbe0d81c076427"
SRC_URI[zbus_macros-1.0.0.sha256sum] = "c0c1f2a20a4cb90922b44d3bebd232b246e52b3dd95ed5bea8aec83cde3a5a8a"
SRC_URI[zvariant-2.0.1.sha256sum] = "f0bf85e67d1a3780cb1c56c80227532354f21907cba14805a773eb507b444580"
SRC_URI[zvariant_derive-2.0.0.sha256sum] = "d68726e8c12757384a8d1485080527e263dea67d91f19e97cd71b9292f22d7c5"

# Modify these as desired
PV = "1.22.0"
SRCREV = "1fac218c7077e5c42882330a7f6ddd6d63f2690f"

SRCREV_FORMAT .= "_fragile"
SRCREV_fragile = "51048ca11824279c2114c77fef5bcb950838fc09"
EXTRA_OECARGO_PATHS += "${WORKDIR}/fragile"

S = "${WORKDIR}/git"

inherit cargo rust meson_rustfix pkgconfig

# allow network access during compile
do_compile[network] = "1"
# CARGO_DISABLE_BITBAKE_VENDORING = "1"

EXTRA_OEMESON = "\
    -Dcargo-flags=[\'--target\',\'${RUST_HOST_SYS}\',\'-v\'] \
    -Dtests=false \
    -Ddepdatadir=${datadir} \
    -Donline=false \
"

export CARGO_FEATURE_STD = "1"

do_configure() {
    cargo_common_do_configure
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
