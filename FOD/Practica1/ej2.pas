program ej2;

type
	archivo = file of integer;
	
function calcularPromedio (t: integer; c: integer) : real;
begin
	calcularPromedio := t/c;

end;

var
	arch_num: archivo;
	nFisico: string;
	cantM, cant, total, num: integer;


begin
	cantM := 0;
	total := 0;
	cant := 0;
	writeln ('Ingrese el nombre del archivo');
	readln (nFisico);
	assign (arch_num, nFisico);
	reset (arch_num);
	while (not eof(arch_num)) do
		begin
			read (arch_num, num);
			if (num < 1500) then
				cantM := cantM + 1;
			total := total + num;
			cant := cant + 1;
			
		end;
	
	close (arch_num);
	
	writeln ('La cantidad de numeros menores que 1500 es ', cantM);
	writeln ('El promedio de los numeros es ', calcularPromedio (total, cant):1:2);
	
	
	
end.

