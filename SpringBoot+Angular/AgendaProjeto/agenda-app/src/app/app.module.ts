import { NgModule } from '@angular/core';

import { ReactiveFormsModule } from '@angular/forms';

import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { MatButtonModule } from '@angular/material/button'
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSnackBarModule } from '@angular/material/snack-bar';

import { AppComponent } from './app.component';
import { ContatoComponent } from './contato/contato.component';
import { ContatoService } from './contato.service';
import { ContatoDetalheComponent } from './contato-detalhe/contato-detalhe.component';

@NgModule({
  declarations: [
    AppComponent,
    ContatoComponent,
    ContatoDetalheComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    MatToolbarModule,
    MatInputModule,
    MatTabsModule,
    MatIconModule,
    MatTableModule,
    MatCardModule,
    MatDialogModule,
    MatPaginatorModule,
    MatSnackBarModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    ContatoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
