program ej9;
const 
    VALORALTO = 32000;
type
    voto = record
        codProvincia : integer;
        codLocalidad: integer;
        numeroMesa: integer;
        cantVotos: integer;
    end;

    archivo = file of voto;



procedure leerVoto (var v: voto);
begin
    writeln ('Provincia: ');
    readln (v.codProvincia);
    writeln ('Localidad: ');
    readln(v.codLocalidad);
    writeln ('Numero mesa: ');
    readln (v.numeroMesa);
    writeln ('Cant votos: ');
    readln (v.cantVotos);

end;


procedure cargarArchivo (var arch: archivo);
var
    v: voto;
begin
    rewrite (arch);
    leerVoto (v);
    while (v.codProvincia <> 9999) do
        begin
            write (arch, v);
            leerVoto (v);

        end;

    close (arch);

end;

procedure leer (var arch: archivo; var v: voto);
begin
    if (not eof(arch)) then
        read (arch, v)
    else
        v.codProvincia := 32000;

end;

procedure procesar (var arch: archivo);
var
    v: voto;
    totalLocalidad, totalProvincia, total, provActual, locActual: integer;
begin
    reset (arch);
    leer (arch, v);
    total := 0;
    while (v.codProvincia <> VALORALTO) do 
        begin
            provActual := v.codProvincia;
            totalProvincia:= 0;
            writeln ('Codigo provincia : ', provActual);
            while (provActual = v.codProvincia) do
                begin
                    locActual := v.codLocalidad;
                    totalLocalidad := 0;
                    while((provActual = v.codProvincia) and (locActual = v.codLocalidad)) do
                        begin
                            totalLocalidad := totalLocalidad + v.cantVotos;
                            totalProvincia := totalProvincia + v.cantVotos;
                            total := total + v.cantVotos;
                            leer (arch, v);

                        end;
                    writeln ('Localidad : ', locActual , ', Votos: ', totalLocalidad);


                end;
            writeln ('Total provincia: ', totalProvincia);



        end;

    writeln ('Total de votos: ', total);

    close (arch);


end;


var 
    arch: archivo;

begin
    assign (arch, 'votos.dat');
    cargarArchivo(arch);
    procesar (arch);



end.



