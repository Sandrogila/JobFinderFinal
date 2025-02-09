package com.example.jobfinder.viewScreen

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.jobfinder.Services.AuthRepository
import com.example.jobfinder.utils.SessionManager
import com.example.jobfinder.viewModel.AuthViewModel
import com.example.jobfinder.viewModel.AuthViewModelFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory(AuthRepository(LocalContext.current)))
) {
    val context = LocalContext.current as Activity

    BackHandler {
        context.moveTaskToBack(true) // Minimiza o app
    }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var selectedRole by remember { mutableStateOf("user") }

    val authResult by authViewModel.authResult.collectAsState()
    val contexte = LocalContext.current
    val sessionManager = remember { SessionManager(contexte) }

    LaunchedEffect(authResult) {
        authResult?.let { result ->
            result.onSuccess {
                sessionManager.saveUserType(selectedRole)
                if (selectedRole == "user") {
                    navController.navigate("user_dashboard")
                } else {
                    navController.navigate("company_dashboard")
                }
            }
            result.onFailure { error ->
                errorMessage = error.message ?: "Erro desconhecido"
            }
        }
    }

    val gradientColors = listOf(Color(0xFFB3DAEE), Color(0xFFB3DAEE))

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("JobFinder", color = Color.White) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF003366))
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = Brush.verticalGradient(gradientColors))
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .padding(24.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "_Login",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF005582)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("E-mail") },
                        leadingIcon={ Icon(Icons.Default.Email, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF0077B5),
                            unfocusedBorderColor = Color.Gray
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Senha") },
                        visualTransformation = PasswordVisualTransformation(),
                        leadingIcon={ Icon(Icons.Default.Lock, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF0077B5),
                            unfocusedBorderColor = Color.Gray
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Selecione o tipo de conta:", fontSize = 16.sp, color = Color.Black)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        RadioButton(
                            selected = selectedRole == "user",
                            onClick = { selectedRole = "user" },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF0077B5),
                                unselectedColor = Color.Gray
                            )
                        )
                        Text("User", color = Color.Black)
                        Spacer(modifier = Modifier.width(16.dp))
                        RadioButton(
                            selected = selectedRole == "company",
                            onClick = { selectedRole = "company" },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF0077B5),
                                unselectedColor = Color.Gray
                            )
                        )
                        Text("Company", color = Color.Black)
                    }
                    if (errorMessage.isNotEmpty()) {
                        Text(errorMessage, color = Color.Red, modifier = Modifier.padding(top = 8.dp))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { authViewModel.login(email, password) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005582)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Entrar", fontSize = 18.sp, color = Color(0xFFEAEFF1))
                    }
                    Spacer(modifier = Modifier.height(3.dp))
                    TextButton(onClick = { navController.navigate("register") }) {
                        Text("Não tem uma conta? Cadastre-se", color = Color.Black)
                    }
                }
            }
        }
    )
}