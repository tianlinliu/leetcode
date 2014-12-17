public class CompareVersionNumbres {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int ver1 = v1.length <= i ? 0 : Integer.parseInt(v1[i]);
            int ver2 = v2.length <= i ? 0 : Integer.parseInt(v2[i]);
            if (ver1 < ver2) {
                return -1;
            } else if (ver1 > ver2) {
                return 1;
            }
        }
        return 0;
    }
}