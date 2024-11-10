package com.techtribeservices.helathline.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.techtribeservices.helathline.R

// font families
val Roboto = FontFamily(
    Font(R.font.roboto_bold),
    Font(R.font.roboto_black),
    Font(R.font.roboto_bold),
    Font(R.font.roboto_regular),
    Font(R.font.roboto_medium),
    Font(R.font.roboto_thin),
    Font(R.font.roboto_light)
)

// Set of Material typography styles to start with
val Typography = Typography(
//    basic font family types
//    val displayLarge: TextStyle = TypographyTokens.DisplayLarge,
//val displayMedium: TextStyle = TypographyTokens.DisplayMedium,
//val displaySmall: TextStyle = TypographyTokens.DisplaySmall,
//val headlineLarge: TextStyle = TypographyTokens.HeadlineLarge,
//val headlineMedium: TextStyle = TypographyTokens.HeadlineMedium,
//val headlineSmall: TextStyle = TypographyTokens.HeadlineSmall,
//val titleLarge: TextStyle = TypographyTokens.TitleLarge,
//val titleMedium: TextStyle = TypographyTokens.TitleMedium,
//val titleSmall: TextStyle = TypographyTokens.TitleSmall,
//val bodyLarge: TextStyle = TypographyTokens.BodyLarge,
//val bodyMedium: TextStyle = TypographyTokens.BodyMedium,
//val bodySmall: TextStyle = TypographyTokens.BodySmall,
//val labelLarge: TextStyle = TypographyTokens.LabelLarge,
//val labelMedium: TextStyle = TypographyTokens.LabelMedium,
//val labelSmall: TextStyle = TypographyTokens.LabelSmall

    displayLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        letterSpacing = -0.25.sp,
        lineHeight = 64.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        letterSpacing = 0.sp,
        lineHeight = 40.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        letterSpacing = 0.sp,
        lineHeight = 36.sp
    ),

    headlineSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        letterSpacing = 0.sp,
        lineHeight = 32.sp
    ),

   titleLarge = TextStyle(
       fontFamily = Roboto,
       fontWeight = FontWeight.Bold,
       fontSize = 22.sp,
       letterSpacing = 0.sp,
       lineHeight = 28.sp
   ),

    titleMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp,
        lineHeight = 24.sp
    ),

    titleSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp,
        lineHeight = 20.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 24.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp,
        lineHeight = 20.sp
    ),

    bodySmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 16.sp
    ),

    labelLarge = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp,
        lineHeight = 20.sp
    ),

    labelMedium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp,
        lineHeight = 16.sp
    ),

    labelSmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp,
        lineHeight = 16.sp
    )
)