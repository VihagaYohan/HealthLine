package com.techtribeservices.helathline.presentation.pages.DoctorDetails.tabs


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.techtribeservices.helathline.ui.theme.HelathLineTheme

@Composable
fun AboutTab() {


    Text(text = getDetails("John Doe", "5", "Cardiologist", "Doe"))
}

private fun getDetails(name:String,experience: String,  speciality: String,
                       lastName: String): String {
    val description:String = "Dr. $name is a highly experienced $speciality with over $experience of professional practice. Committed to providing the highest quality care, Dr. $lastName has successfully treated countless patients, focusing on $speciality, e.g., \"advanced treatments for heart-related conditions\".\n" +
            "\n" +
            "Dr. $lastName earned their medical degree from Coventry University in London, UK, and completed advanced training in $speciality. With a passion for staying at the forefront of medical advancements, Dr. $lastName regularly attends conferences, contributes to research, and integrates the latest techniques into their practice.\n" +
            "\n" +
            "Known for their compassionate approach, Dr. $speciality prioritizes understanding patients’ unique needs and delivering personalized care. They believe in fostering a strong doctor-patient relationship, empowering individuals to take charge of their health and make informed decisions"

    return description
}

@Preview(showBackground = true)
@Composable
fun AboutTabPreview() {
    HelathLineTheme {

    }
}