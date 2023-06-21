
Program ej7-1;

Type 
    especie =   Record
        codigo:   integer;
        nombre:   string;
        familia:   string;
        descripcion:   string;
        zona:   string;

        archivo:   file Of especie;


        Procedure borrar (Var arch: archivo);

        Var 
            codigoBorrar:   integer;
            e:   especie;
            encontre :   boolean;
            cantBorrados:   integer;

        Begin
            reset (arch)
            writeln ('Ingrese un codigo a borrar');
            readln (codigoBorrar);
            While (codigoBorrar <> 500000) Do
                Begin
                    encontre := false;
                    While (Not eof(arch) And (Not encontre)) Do
                        Begin
                            read (arch, e);
                            If (e.codigo = codigoBorrar) Then
                                Begin
                                    e.codigo := e.codigo * -1;
                                    encontre := true;
                                    cantBorrados := cantBorrados + 1;
                                End;
                        End;

                    seek (arch, 0);
                End;
        End;


        Procedure compactar (Var arch: archivo; cantBorrados: integer);

        Var 
            i, pos:   integer;
            e:   especie;

        Begin
            reset (arch)
            i := 1;

            While (Not eof(arch) And i<=cantBorrados) Do
                Begin
                    read (arch, e);
                    If (e.codigo < 0) Then
                        Begin
                            pos := FilePos(arch) - 1;
                            seek (arch, FileSize(arch) - i);
                            read (arch, e);
                            seek (arch, pos);
                            write (arch, e);
                            i := i + 1;
                        End;

                End;

            seek (arch, FileSize(arch) - (cantBorrados+1));
            truncate(arch);
        End;
    End;
