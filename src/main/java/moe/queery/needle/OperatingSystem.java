package moe.queery.needle;

public enum OperatingSystem { // TODO: recode
    WIN_X86, WIN_X64, WIN_ARM64,
    LINUX_X86, LINUX_X64, LINUX_ARM64,
    MAC_X64, MAC_X86, MAC_ARM64,
    UNKNOWN;

    private static final String os = System.getProperty("os.name").toLowerCase();
    private static final String arch = System.getProperty("os.arch").toLowerCase();

    private static final OperatingSystem OS;

    static {
        boolean isX86 = false, isX64 = false, isARM64 = false;
        switch (arch) {
            case "x86_64":
            case "x86-64": {
                isX86 = true;
                break;
            }
            case "aarch64": {
                isARM64 = true;
                break;
            }
            case "amd64": {
                isX64 = true;
                break;
            }
        }
        if (!isX86 && !isX64 && !isARM64) OS = UNKNOWN;
        else {
            if (os.contains("win")) OS = isARM64 ? WIN_ARM64 : isX64 ? WIN_X64 : isX86 ? WIN_X86 : UNKNOWN;
            else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) OS = isARM64 ? LINUX_ARM64
                    : isX64 ? LINUX_X64 : isX86 ? LINUX_X86 : UNKNOWN;
            else if (os.contains("mac") || os.contains("osx")) OS = isARM64 ? MAC_ARM64 : isX64 ? MAC_X64
                    : isX86 ? MAC_X86 : UNKNOWN;
            else OS = UNKNOWN;
        }
    }

    public static OperatingSystem getCurrent() {
        return OS;
    }
}
