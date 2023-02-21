#version 330

out vec4 fragColor;
uniform vec4 uni_color;
//in vec4 out_color;

void main() {
    // vec4(red, green, blue, alpha)
    fragColor = uni_color;
}