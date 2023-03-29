

program hola;

type
	archivo = file of integer;

var
	arch_num : archivo;
	num: integer;



BEGIN
	assign(arch_num, 'archivoN.dat');
	rewrite (arch_num);
	writeln ('Ingrese un numero');
	readln (num);
	while (num <> 0) do 
		begin
			write (arch_num, num);
			writeln ('Ingrese otro numero');
			readln (num);
		
		end;
	close(arch_num)
	
	
END.

