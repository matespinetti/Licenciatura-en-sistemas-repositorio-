program ej10;
const
    VALORALTO = 'ZZZZ';
type
    empleado = record
        departamento : string;
        division: string;
        numero: integer;
        categoria: integer;
        horas: integer;
    end;

    total = record
        horas: integer;
        monto: real;
    end;



    archivo = file of empleado;
    vectorCat = array[1..15] of real;




procedure cargarCategorias (var horas: text; var v: vectorCat);
var
    cat: integer;
    valor: real;
begin
    reset (horas);
    while (not Eof(horas)) do
      begin
        read(horas, cat, valor);
        v[cat] := valor;
      end;  
    Close(horas);

end;


procedure leer (var arch: archivo; var e: empleado);
begin
    if (not Eof(arch)) then
        read (arch, e)
    else
        e.departamento := VALORALTO;
end;

procedure leerEmpleado (var e: empleado);
begin
    WriteLn('Ingrese departamento: ');
    readln (e.departamento);
    WriteLn('Ingrese division: ');
    readln (e.division);   
    WriteLn('Ingrese numero empleado: ');
    readln (e.numero);   
    WriteLn('Ingrese categoria: ');
    readln (e.categoria);   
    WriteLn('Ingrese cantidad horas: ');
    readln (e.horas);       

end;


procedure cargarEmpleados (var arch: archivo);
var
    e: empleado;

begin
    rewrite (arch);
    leerEmpleado(e);
    while (e.departamento <> 'ZZZZ') do
        begin
            write (arch, e);
            leerEmpleado(e);
          
        end;
    close (arch);

end;

procedure procesar (var arch: archivo; var horas: text);
var
    v: vectorCat;
    e: empleado;
    actual: empleado;
    totalEmp, totalDiv, totalDep: total;


begin
    cargarCategorias(horas, v);
    reset(arch);
    leer(arch, e);
    while (e.departamento <> VALORALTO) do 
        begin
            totalDep.horas := 0;
            totalDep.monto := 0;
            actual.departamento := e.departamento;
            writeln ('Departamento: ', actual.departamento);
            while ( actual.departamento = e.departamento) do
                begin
                    totalDiv.horas := 0;
                    totalDiv.monto := 0;
                    actual.division := e.division;
                    WriteLn ('Division: ', actual.division);
                    while (( actual.departamento = e.departamento) and (actual.division = e.division)) do
                        begin
                            totalEmp.horas := 0;
                            totalEmp.monto := 0;
                            actual.numero := e.numero;
                            while (( actual.departamento = e.departamento) and (actual.division = e.division) and (actual.numero = e.numero)) do
                                begin
                                    totalEmp.horas := totalEmp.horas + e.horas;
                                    totalDep.horas := totalDep.horas + e.horas;
                                    totalDiv.horas := totalDiv.horas + e.horas;
                                    totalEmp.monto := totalEmp.monto + (v[e.categoria] * e.horas);
                                    totalDiv.monto := totalDiv.monto + (v[e.categoria] * e.horas);
                                    totalDep.monto := totalDep.monto + (v[e.categoria] * e.horas);

                                    leer (arch, e); 

                                end; 
                            writeln ('Numero empleado: ', actual.numero, ', totalHoras: ', totalEmp.horas, ' Importe a cobrar: ', totalEmp.monto);
            

                        end;
                    WriteLn ('Horas division: ', totalDiv.horas);
                    writeln ('Monto total divison: ', totalDiv.monto);
                  


                end;
            writeln ('Horas departamento: ', totalDep.horas);
            writeln ('Monto total departamento: ', totalDep.monto);



        end;
    
    close (arch);




end;
var
    arch: archivo;
    horas: text;

begin
    Assign(arch, 'empleados.dat');
    Assign(horas, 'horas.txt');
    //cargarEmpleados(arch);
    procesar(arch, horas);



end.