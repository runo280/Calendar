package io.github.persiancalendar.calendar

import org.junit.Assert
import org.junit.Test

class AllPersianCalendarLeapYears {

    // https://github.com/dotnet/runtime/blob/57bfe474/src/libraries/System.Globalization.Calendars/tests/System/Globalization/PersianCalendarTests.cs#L246
    private val leapYears = listOf(
        5, 9, 13, 17, 21, 25, 29, 33, 38, 42, 46, 50, 54, 58, 62, 66, 71, 75, 79, 83, 87, 91, 95, 99,
        104, 108, 112, 116, 120, 124, 128, 132, 137, 141, 145, 149, 153, 157, 161, 166, 170, 174, 178, 182, 186, 190,
        194, 199, 203, 207, 211, 215, 219, 223, 227, 232, 236, 240, 244, 248, 252, 256, 260, 265, 269, 273, 277, 281,
        285, 289, 293, 298, 302, 306, 310, 314, 318, 322, 327, 331, 335, 339, 343, 347, 351, 355, 359, 364, 368, 372,
        376, 380, 384, 388, 392, 397, 401, 405, 409, 413, 417, 421, 426, 430, 434, 438, 442, 446, 450, 454, 459, 463,
        467, 471, 475, 479, 483, 487, 492, 496, 500, 504, 508, 512, 516, 520, 525, 529, 533, 537, 541, 545, 549, 553,
        558, 562, 566, 570, 574, 578, 582, 586, 591, 595, 599, 603, 607, 611, 615, 619, 624, 628, 632, 636, 640, 644,
        648, 652, 657, 661, 665, 669, 673, 677, 681, 686, 690, 694, 698, 702, 706, 710, 714, 719, 723, 727, 731, 735,
        739, 743, 747, 752, 756, 760, 764, 768, 772, 776, 780, 785, 789, 793, 797, 801, 805, 809, 813, 818, 822, 826,
        830, 834, 838, 842, 846, 851, 855, 859, 863, 867, 871, 875, 879, 884, 888, 892, 896, 900, 904, 908, 912, 917,
        921, 925, 929, 933, 937, 941, 945, 950, 954, 958, 962, 966, 970, 974, 978, 983, 987, 991, 995, 999,
        1003, 1007, 1011, 1016, 1020, 1024, 1028, 1032, 1036, 1040, 1044, 1049, 1053, 1057, 1061, 1065, 1069, 1073,
        1077, 1082, 1086, 1090, 1094, 1098, 1102, 1106, 1111, 1115, 1119, 1123, 1127, 1131, 1135, 1139, 1144, 1148,
        1152, 1156, 1160, 1164, 1168, 1172, 1176, 1181, 1185, 1189, 1193, 1197, 1201, 1205, 1210, 1214, 1218, 1222,
        1226, 1230, 1234, 1238, 1243, 1247, 1251, 1255, 1259, 1263, 1267, 1271, 1276, 1280, 1284, 1288, 1292, 1296,
        1300, 1304, 1309, 1313, 1317, 1321, 1325, 1329, 1333, 1337, 1342, 1346, 1350, 1354, 1358, 1362, 1366, 1370,
        1375, 1379, 1383, 1387, 1391, 1395, 1399, 1403, 1408, 1412, 1416, 1420, 1424, 1428, 1432, 1436, 1441, 1445,
        1449, 1453, 1457, 1461, 1465, 1469, 1474, 1478, 1482, 1486, 1490, 1494, 1498, 1503, 1507, 1511, 1515, 1519,
        1523, 1527, 1531, 1536, 1540, 1544, 1548, 1552, 1556, 1560, 1564, 1568, 1573, 1577, 1581, 1585, 1589, 1593,
        1597, 1602, 1606, 1610, 1614, 1618, 1622, 1626, 1630, 1635, 1639, 1643, 1647, 1651, 1655, 1659, 1663, 1668,
        1672, 1676, 1680, 1684, 1688, 1692, 1696, 1701, 1705, 1709, 1713, 1717, 1721, 1725, 1729, 1734, 1738, 1742,
        1746, 1750, 1754, 1758, 1762, 1767, 1771, 1775, 1779, 1783, 1787, 1791, 1795, 1800, 1804, 1808, 1812, 1816,
        1820, 1824, 1828, 1833, 1837, 1841, 1845, 1849, 1853, 1857, 1861, 1866, 1870, 1874, 1878, 1882, 1886, 1890,
        1894, 1899, 1903, 1907, 1911, 1915, 1919, 1923, 1927, 1932, 1936, 1940, 1944, 1948, 1952, 1956, 1960, 1965,
        1969, 1973, 1977, 1981, 1985, 1989, 1993, 1998, 2002, 2006, 2010, 2014, 2018, 2022, 2027, 2031, 2035, 2039,
        2043, 2047, 2051, 2055, 2060, 2064, 2068, 2072, 2076, 2080, 2084, 2088, 2093, 2097, 2101, 2105, 2109, 2113,
        2117, 2121, 2125, 2130, 2134, 2138, 2142, 2146, 2150, 2154, 2159, 2163, 2167, 2171, 2175, 2179, 2183, 2187,
        2192, 2196, 2200, 2204, 2208, 2212, 2216, 2220, 2225, 2229, 2233, 2237, 2241, 2245, 2249, 2253, 2258, 2262,
        2266, 2270, 2274, 2278, 2282, 2286, 2291, 2295, 2299, 2303, 2307, 2311, 2315, 2319, 2324, 2328, 2332, 2336,
        2340, 2344, 2348, 2352, 2357, 2361, 2365, 2369, 2373, 2377, 2381, 2385, 2390, 2394, 2398, 2402, 2406, 2410,
        2414, 2418, 2423, 2427, 2431, 2435, 2439, 2443, 2447, 2451, 2456, 2460, 2464, 2468, 2472, 2476, 2480, 2484,
        2489, 2493, 2497, 2501, 2505, 2509, 2513, 2517, 2522, 2526, 2530, 2534, 2538, 2542, 2546, 2550, 2555, 2559,
        2563, 2567, 2571, 2575, 2579, 2584, 2588, 2592, 2596, 2600, 2604, 2608, 2612, 2617, 2621, 2625, 2629, 2633,
        2637, 2641, 2645, 2649, 2654, 2658, 2662, 2666, 2670, 2674, 2678, 2682, 2687, 2691, 2695, 2699, 2703, 2707,
        2711, 2716, 2720, 2724, 2728, 2732, 2736, 2740, 2744, 2749, 2753, 2757, 2761, 2765, 2769, 2773, 2777, 2782,
        2786, 2790, 2794, 2798, 2802, 2806, 2810, 2814, 2819, 2823, 2827, 2831, 2835, 2839, 2843, 2848, 2852, 2856,
        2860, 2864, 2868, 2872, 2876, 2881, 2885, 2889, 2893, 2897, 2901, 2905, 2909, 2914, 2918, 2922, 2926, 2930,
        2934, 2938, 2942, 2947, 2951, 2955, 2959, 2963, 2967, 2971, 2975, 2980, 2984, 2988, 2992, 2996, 3000, 3004,
        3008, 3013, 3017, 3021, 3025, 3029, 3033, 3037, 3041, 3046, 3050, 3054, 3058, 3062, 3066, 3070, 3074, 3079,
        3083, 3087, 3091, 3095, 3099, 3103, 3107, 3112, 3116, 3120, 3124, 3128, 3132, 3136, 3141, 3145, 3149, 3153,
        3157, 3161, 3165, 3169, 3173, 3178, 3182, 3186, 3190, 3194, 3198, 3202, 3206, 3211, 3215, 3219, 3223, 3227,
        3231, 3235, 3239, 3244, 3248, 3252, 3256, 3260, 3264, 3268, 3273, 3277, 3281, 3285, 3289, 3293, 3297, 3301,
        3306, 3310, 3314, 3318, 3322, 3326, 3330, 3334, 3339, 3343, 3347, 3351, 3355, 3359, 3363, 3367, 3372, 3376,
        3380, 3384, 3388, 3392, 3396, 3400, 3405, 3409, 3413, 3417, 3421, 3425, 3429, 3433, 3438, 3442, 3446, 3450,
        3454, 3458, 3462, 3466, 3471, 3475, 3479, 3483, 3487, 3491, 3495, 3499, 3504, 3508, 3512, 3516, 3520, 3524,
        3528, 3532, 3537, 3541, 3545, 3549, 3553, 3557, 3561, 3565, 3570, 3574, 3578, 3582, 3586, 3590, 3594, 3598,
        3603, 3607, 3611, 3615, 3619, 3623, 3627, 3631, 3636, 3640, 3644, 3648, 3652, 3656, 3660, 3665, 3669, 3673,
        3677, 3681, 3685, 3689, 3693, 3698, 3702, 3706, 3710, 3714, 3718, 3722, 3726, 3731, 3735, 3739, 3743, 3747,
        3751, 3755, 3759, 3764, 3768, 3772, 3776, 3780, 3784, 3788, 3792, 3797, 3801, 3805, 3809, 3813, 3817, 3821,
        3825, 3830, 3834, 3838, 3842, 3846, 3850, 3854, 3858, 3863, 3867, 3871, 3875, 3879, 3883, 3887, 3891, 3896,
        3900, 3904, 3908, 3912, 3916, 3920, 3925, 3929, 3933, 3937, 3941, 3945, 3949, 3953, 3958, 3962, 3966, 3970,
        3974, 3978, 3982, 3986, 3991, 3995, 3999, 4003, 4007, 4011, 4015, 4019, 4024, 4028, 4032, 4036, 4040, 4044,
        4048, 4052, 4057, 4061, 4065, 4069, 4073, 4077, 4081, 4085, 4090, 4094, 4098, 4102, 4106, 4110, 4114, 4118,
        4123, 4127, 4131, 4135, 4139, 4143, 4147, 4151, 4156, 4160, 4164, 4168, 4172, 4176, 4180, 4185, 4189, 4193,
        4197, 4201, 4205, 4209, 4213, 4218, 4222, 4226, 4230, 4234, 4238, 4242, 4246, 4251, 4255, 4259, 4263, 4267,
        4271, 4275, 4279, 4284, 4288, 4292, 4296, 4300, 4304, 4308, 4312, 4317, 4321, 4325, 4329, 4333, 4337, 4341,
        4345, 4350, 4354, 4358, 4362, 4366, 4370, 4374, 4378, 4383, 4387, 4391, 4395, 4399, 4403, 4407, 4411, 4416,
        4420, 4424, 4428, 4432, 4436, 4440, 4445, 4449, 4453, 4457, 4461, 4465, 4469, 4473, 4478, 4482, 4486, 4490,
        4494, 4498, 4502, 4506, 4511, 4515, 4519, 4523, 4527, 4531, 4535, 4539, 4544, 4548, 4552, 4556, 4560, 4564,
        4568, 4572, 4577, 4581, 4585, 4589, 4593, 4597, 4601, 4605, 4610, 4614, 4618, 4622, 4626, 4630, 4634, 4638,
        4643, 4647, 4651, 4655, 4659, 4663, 4667, 4672, 4676, 4680, 4684, 4688, 4692, 4696, 4700, 4705, 4709, 4713,
        4717, 4721, 4725, 4729, 4733, 4738, 4742, 4746, 4750, 4754, 4758, 4762, 4766, 4771, 4775, 4779, 4783, 4787,
        4791, 4795, 4800, 4804, 4808, 4812, 4816, 4820, 4824, 4828, 4833, 4837, 4841, 4845, 4849, 4853, 4857, 4861,
        4866, 4870, 4874, 4878, 4882, 4886, 4890, 4894, 4899, 4903, 4907, 4911, 4915, 4919, 4923, 4927, 4932, 4936,
        4940, 4944, 4948, 4952, 4956, 4960, 4965, 4969, 4973, 4977, 4981, 4985, 4989, 4993, 4998, 5002, 5006, 5010,
        5014, 5018, 5022, 5027, 5031, 5035, 5039, 5043, 5047, 5051, 5055, 5060, 5064, 5068, 5072, 5076, 5080, 5084,
        5088, 5093, 5097, 5101, 5105, 5109, 5113, 5117, 5121, 5126, 5130, 5134, 5138, 5142, 5146, 5150, 5155, 5159,
        5163, 5167, 5171, 5175, 5179, 5183, 5188, 5192, 5196, 5200, 5204, 5208, 5212, 5216, 5221, 5225, 5229, 5233,
        5237, 5241, 5245, 5249, 5254, 5258, 5262, 5266, 5270, 5274, 5278, 5283, 5287, 5291, 5295, 5299, 5303, 5307,
        5311, 5316, 5320, 5324, 5328, 5332, 5336, 5340, 5344, 5349, 5353, 5357, 5361, 5365, 5369, 5373, 5377, 5382,
        5386, 5390, 5394, 5398, 5402, 5406, 5411, 5415, 5419, 5423, 5427, 5431, 5435, 5439, 5444, 5448, 5452, 5456,
        5460, 5464, 5468, 5472, 5477, 5481, 5485, 5489, 5493, 5497, 5501, 5506, 5510, 5514, 5518, 5522, 5526, 5530,
        5534, 5539, 5543, 5547, 5551, 5555, 5559, 5563, 5567, 5572, 5576, 5580, 5584, 5588, 5592, 5596, 5601, 5605,
        5609, 5613, 5617, 5621, 5625, 5629, 5634, 5638, 5642, 5646, 5650, 5654, 5658, 5662, 5667, 5671, 5675, 5679,
        5683, 5687, 5691, 5695, 5700, 5704, 5708, 5712, 5716, 5720, 5724, 5729, 5733, 5737, 5741, 5745, 5749, 5753,
        5757, 5762, 5766, 5770, 5774, 5778, 5782, 5786, 5790, 5795, 5799, 5803, 5807, 5811, 5815, 5819, 5824, 5828,
        5832, 5836, 5840, 5844, 5848, 5852, 5857, 5861, 5865, 5869, 5873, 5877, 5881, 5885, 5890, 5894, 5898, 5902,
        5906, 5910, 5914, 5919, 5923, 5927, 5931, 5935, 5939, 5943, 5947, 5952, 5956, 5960, 5964, 5968, 5972, 5976,
        5980, 5985, 5989, 5993, 5997, 6001, 6005, 6009, 6014, 6018, 6022, 6026, 6030, 6034, 6038, 6042, 6047, 6051,
        6055, 6059, 6063, 6067, 6071, 6076, 6080, 6084, 6088, 6092, 6096, 6100, 6104, 6109, 6113, 6117, 6121, 6125,
        6129, 6133, 6138, 6142, 6146, 6150, 6154, 6158, 6162, 6166, 6171, 6175, 6179, 6183, 6187, 6191, 6195, 6199,
        6204, 6208, 6212, 6216, 6220, 6224, 6228, 6233, 6237, 6241, 6245, 6249, 6253, 6257, 6261, 6266, 6270, 6274,
        6278, 6282, 6286, 6290, 6294, 6299, 6303, 6307, 6311, 6315, 6319, 6323, 6328, 6332, 6336, 6340, 6344, 6348,
        6352, 6356, 6361, 6365, 6369, 6373, 6377, 6381, 6385, 6389, 6394, 6398, 6402, 6406, 6410, 6414, 6418, 6423,
        6427, 6431, 6435, 6439, 6443, 6447, 6452, 6456, 6460, 6464, 6468, 6472, 6476, 6480, 6485, 6489, 6493, 6497,
        6501, 6505, 6509, 6513, 6518, 6522, 6526, 6530, 6534, 6538, 6542, 6547, 6551, 6555, 6559, 6563, 6567, 6571,
        6575, 6580, 6584, 6588, 6592, 6596, 6600, 6604, 6608, 6613, 6617, 6621, 6625, 6629, 6633, 6637, 6642, 6646,
        6650, 6654, 6658, 6662, 6666, 6671, 6675, 6679, 6683, 6687, 6691, 6695, 6699, 6704, 6708, 6712, 6716, 6720,
        6724, 6728, 6733, 6737, 6741, 6745, 6749, 6753, 6757, 6761, 6766, 6770, 6774, 6778, 6782, 6786, 6790, 6794,
        6799, 6803, 6807, 6811, 6815, 6819, 6823, 6828, 6832, 6836, 6840, 6844, 6848, 6852, 6856, 6861, 6865, 6869,
        6873, 6877, 6881, 6885, 6890, 6894, 6898, 6902, 6906, 6910, 6914, 6919, 6923, 6927, 6931, 6935, 6939, 6943,
        6947, 6952, 6956, 6960, 6964, 6968, 6972, 6976, 6980, 6985, 6989, 6993, 6997, 7001, 7005, 7009, 7014, 7018,
        7022, 7026, 7030, 7034, 7038, 7043, 7047, 7051, 7055, 7059, 7063, 7067, 7071, 7076, 7080, 7084, 7088, 7092,
        7096, 7100, 7105, 7109, 7113, 7117, 7121, 7125, 7129, 7133, 7138, 7142, 7146, 7150, 7154, 7158, 7162, 7167,
        7171, 7175, 7179, 7183, 7187, 7191, 7196, 7200, 7204, 7208, 7212, 7216, 7220, 7224, 7229, 7233, 7237, 7241,
        7245, 7249, 7253, 7258, 7262, 7266, 7270, 7274, 7278, 7282, 7286, 7291, 7295, 7299, 7303, 7307, 7311, 7315,
        7320, 7324, 7328, 7332, 7336, 7340, 7344, 7349, 7353, 7357, 7361, 7365, 7369, 7373, 7377, 7382, 7386, 7390,
        7394, 7398, 7402, 7406, 7411, 7415, 7419, 7423, 7427, 7431, 7435, 7439, 7444, 7448, 7452, 7456, 7460, 7464,
        7468, 7473, 7477, 7481, 7485, 7489, 7493, 7497, 7502, 7506, 7510, 7514, 7518, 7522, 7526, 7531, 7535, 7539,
        7543, 7547, 7551, 7555, 7559, 7564, 7568, 7572, 7576, 7580, 7584, 7588, 7593, 7597, 7601, 7605, 7609, 7613,
        7617, 7621, 7626, 7630, 7634, 7638, 7642, 7646, 7650, 7655, 7659, 7663, 7667, 7671, 7675, 7679, 7684, 7688,
        7692, 7696, 7700, 7704, 7708, 7712, 7717, 7721, 7725, 7729, 7733, 7737, 7741, 7746, 7750, 7754, 7758, 7762,
        7766, 7770, 7775, 7779, 7783, 7787, 7791, 7795, 7799, 7803, 7808, 7812, 7816, 7820, 7824, 7828, 7832, 7837,
        7841, 7845, 7849, 7853, 7857, 7861, 7866, 7870, 7874, 7878, 7882, 7886, 7890, 7894, 7899, 7903, 7907, 7911,
        7915, 7919, 7923, 7928, 7932, 7936, 7940, 7944, 7948, 7952, 7957, 7961, 7965, 7969, 7973, 7977, 7981, 7986,
        7990, 7994, 7998, 8002, 8006, 8010, 8015, 8019, 8023, 8027, 8031, 8035, 8039, 8043, 8048, 8052, 8056, 8060,
        8064, 8068, 8072, 8077, 8081, 8085, 8089, 8093, 8097, 8101, 8106, 8110, 8114, 8118, 8122, 8126, 8130, 8134,
        8139, 8143, 8147, 8151, 8155, 8159, 8163, 8168, 8172, 8176, 8180, 8184, 8188, 8192, 8197, 8201, 8205, 8209,
        8213, 8217, 8221, 8226, 8230, 8234, 8238, 8242, 8246, 8250, 8255, 8259, 8263, 8267, 8271, 8275, 8279, 8283,
        8288, 8292, 8296, 8300, 8304, 8308, 8312, 8317, 8321, 8325, 8329, 8333, 8337, 8341, 8346, 8350, 8354, 8358,
        8362, 8366, 8370, 8375, 8379, 8383, 8387, 8391, 8395, 8399, 8403, 8408, 8412, 8416, 8420, 8424, 8428, 8432,
        8437, 8441, 8445, 8449, 8453, 8457, 8461, 8466, 8470, 8474, 8478, 8482, 8486, 8490, 8495, 8499, 8503, 8507,
        8511, 8515, 8519, 8524, 8528, 8532, 8536, 8540, 8544, 8548, 8553, 8557, 8561, 8565, 8569, 8573, 8577, 8581,
        8586, 8590, 8594, 8598, 8602, 8606, 8610, 8615, 8619, 8623, 8627, 8631, 8635, 8639, 8644, 8648, 8652, 8656,
        8660, 8664, 8668, 8673, 8677, 8681, 8685, 8689, 8693, 8697, 8702, 8706, 8710, 8714, 8718, 8722, 8726, 8731,
        8735, 8739, 8743, 8747, 8751, 8755, 8760, 8764, 8768, 8772, 8776, 8780, 8784, 8789, 8793, 8797, 8801, 8805,
        8809, 8813, 8818, 8822, 8826, 8830, 8834, 8838, 8842, 8846, 8851, 8855, 8859, 8863, 8867, 8871, 8875, 8880,
        8884, 8888, 8892, 8896, 8900, 8904, 8909, 8913, 8917, 8921, 8925, 8929, 8933, 8938, 8942, 8946, 8950, 8954,
        8958, 8962, 8967, 8971, 8975, 8979, 8983, 8987, 8991, 8996, 9000, 9004, 9008, 9012, 9016, 9020, 9025, 9029,
        9033, 9037, 9041, 9045, 9049, 9054, 9058, 9062, 9066, 9070, 9074, 9078, 9083, 9087, 9091, 9095, 9099, 9103,
        9107, 9112, 9116, 9120, 9124, 9128, 9132, 9136, 9141, 9145, 9149, 9153, 9157, 9161, 9165, 9170, 9174, 9178,
        9182, 9186, 9190, 9194, 9199, 9203, 9207, 9211, 9215, 9219, 9223, 9228, 9232, 9236, 9240, 9244, 9248, 9252,
        9257, 9261, 9265, 9269, 9273, 9277, 9281, 9286, 9290, 9294, 9298, 9302, 9306, 9310, 9315, 9319, 9323, 9327,
        9331, 9335, 9339, 9344, 9348, 9352, 9356, 9360, 9364, 9368, 9373, 9377
    )

    @Test
    fun `Conforms with dotnet Persian calendar leap years`() = (1..9377).forEach {
        val yearLength = PersianDate(it + 1, 1, 1).toJdn() - PersianDate(it, 1, 1).toJdn()
        Assert.assertEquals(it.toString(), if (it in leapYears) 366 else 365, yearLength)
    }
}