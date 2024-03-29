package com.bakigoal.easy

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    val color = image[sr][sc]
    if (color != newColor) dfs(image, sr, sc, color, newColor)
    return image
}

fun dfs(image: Array<IntArray>, r: Int, c: Int, color: Int, newColor: Int) {
    if (image[r][c] == color) {
        image[r][c] = newColor
        if (r >= 1) dfs(image, r - 1, c, color, newColor)
        if (c >= 1) dfs(image, r, c - 1, color, newColor)
        if (r + 1 < image.size) dfs(image, r + 1, c, color, newColor)
        if (c + 1 < image[0].size) dfs(image, r, c + 1, color, newColor)
    }
}