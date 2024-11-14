

import type { Metadata } from "next";
import localFont from "next/font/local";
import "./globals.css";
import TransitionLayout from '@/components/ui/transition-layout'
import { AuthProvider } from "./context/useAuth";

const geistSans = localFont({
  src: "./fonts/GeistVF.woff",
  variable: "--font-geist-sans",
  weight: "100 900",
});
const geistMono = localFont({
  src: "./fonts/GeistMonoVF.woff",
  variable: "--font-geist-mono",
  weight: "100 900",
});

export const metadata: Metadata = {
  title: "AbbaApplication",
  description: "Application for Abba",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body
        className={`${geistSans.variable} ${geistMono.variable} antialiased`}
      >
          <AuthProvider>
            <TransitionLayout>{children}</TransitionLayout>
          </AuthProvider>

      </body>
    </html>
  );
}
