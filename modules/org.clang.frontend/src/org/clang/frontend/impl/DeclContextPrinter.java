/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.frontend.impl;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.ast.*;
import static org.clang.ast.AstClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclContextPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 187,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 184,
 FQN="(anonymous namespace)::DeclContextPrinter", NM="_ZN12_GLOBAL__N_118DeclContextPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_118DeclContextPrinterE")
//</editor-fold>
public class DeclContextPrinter extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
  private raw_ostream /*&*/ Out;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclContextPrinter::DeclContextPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 190,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 187,
   FQN="(anonymous namespace)::DeclContextPrinter::DeclContextPrinter", NM="_ZN12_GLOBAL__N_118DeclContextPrinterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_118DeclContextPrinterC1Ev")
  //</editor-fold>
  public DeclContextPrinter() {
    // : ASTConsumer(), Out(llvm::errs()) 
    //START JInit
    super();
    this./*&*/Out=/*&*/llvm.errs();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclContextPrinter::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 192,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 189,
   FQN="(anonymous namespace)::DeclContextPrinter::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_118DeclContextPrinter21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_118DeclContextPrinter21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(ASTContext /*&*/ C)/* override*/ {
    PrintDeclContext(C.getTranslationUnitDecl(), 4);
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclContextPrinter::PrintDeclContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*renamed inner DC var*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 200,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 197,
   FQN="(anonymous namespace)::DeclContextPrinter::PrintDeclContext", NM="_ZN12_GLOBAL__N_118DeclContextPrinter16PrintDeclContextEPKN5clang11DeclContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_118DeclContextPrinter16PrintDeclContextEPKN5clang11DeclContextEj")
  //</editor-fold>
  public void PrintDeclContext(/*const*/ DeclContext /*P*/ DC, 
                  /*uint*/int Indentation) {
    // Print DeclContext name.
    switch (DC.getDeclKind()) {
     case TranslationUnit:
      Out.$out(/*KEEP_STR*/"[translation unit] ").$out(DC);
      break;
     case Namespace:
      {
        Out.$out(/*KEEP_STR*/"[namespace] ");
        /*const*/ NamespaceDecl /*P*/ ND = cast(NamespaceDecl.class, DC);
        $out_raw_ostream_NamedDecl$C(Out, /*Deref*/ND);
        break;
      }
     case Enum:
      {
        /*const*/ EnumDecl /*P*/ ED = cast(EnumDecl.class, DC);
        if (ED.isCompleteDefinition()) {
          Out.$out(/*KEEP_STR*/"[enum] ");
        } else {
          Out.$out(/*KEEP_STR*/"<enum> ");
        }
        $out_raw_ostream_NamedDecl$C(Out, /*Deref*/ED);
        break;
      }
     case Record:
      {
        /*const*/ RecordDecl /*P*/ RD = cast(RecordDecl.class, DC);
        if (RD.isCompleteDefinition()) {
          Out.$out(/*KEEP_STR*/"[struct] ");
        } else {
          Out.$out(/*KEEP_STR*/"<struct> ");
        }
        $out_raw_ostream_NamedDecl$C(Out, /*Deref*/RD);
        break;
      }
     case CXXRecord:
      {
        /*const*/ CXXRecordDecl /*P*/ RD = cast(CXXRecordDecl.class, DC);
        if (RD.isCompleteDefinition()) {
          Out.$out(/*KEEP_STR*/"[class] ");
        } else {
          Out.$out(/*KEEP_STR*/"<class> ");
        }
        $out_raw_ostream_NamedDecl$C(Out, /*Deref*/RD).$out_char($$SPACE).$out(DC);
        break;
      }
     case ObjCMethod:
      Out.$out(/*KEEP_STR*/"[objc method]");
      break;
     case ObjCInterface:
      Out.$out(/*KEEP_STR*/"[objc interface]");
      break;
     case ObjCCategory:
      Out.$out(/*KEEP_STR*/"[objc category]");
      break;
     case ObjCProtocol:
      Out.$out(/*KEEP_STR*/"[objc protocol]");
      break;
     case ObjCImplementation:
      Out.$out(/*KEEP_STR*/"[objc implementation]");
      break;
     case ObjCCategoryImpl:
      Out.$out(/*KEEP_STR*/"[objc categoryimpl]");
      break;
     case LinkageSpec:
      Out.$out(/*KEEP_STR*/"[linkage spec]");
      break;
     case Block:
      Out.$out(/*KEEP_STR*/"[block]");
      break;
     case Function:
      {
        /*const*/ FunctionDecl /*P*/ FD = cast(FunctionDecl.class, DC);
        if (FD.doesThisDeclarationHaveABody()) {
          Out.$out(/*KEEP_STR*/"[function] ");
        } else {
          Out.$out(/*KEEP_STR*/"<function> ");
        }
        $out_raw_ostream_NamedDecl$C(Out, /*Deref*/FD);
        // Print the parameters.
        Out.$out(/*KEEP_STR*/$LPAREN);
        boolean PrintComma = false;
        for (ParmVarDecl /*P*/ I : FD.parameters$Const()) {
          if (PrintComma) {
            Out.$out(/*KEEP_STR*/$COMMA_SPACE);
          } else {
            PrintComma = true;
          }
          $out_raw_ostream_NamedDecl$C(Out, /*Deref*/I);
        }
        Out.$out(/*KEEP_STR*/$RPAREN);
        break;
      }
     case CXXMethod:
      {
        /*const*/ CXXMethodDecl /*P*/ D = cast(CXXMethodDecl.class, DC);
        if (D.isOutOfLine()) {
          Out.$out(/*KEEP_STR*/"[c++ method] ");
        } else if (D.isImplicit()) {
          Out.$out(/*KEEP_STR*/"(c++ method) ");
        } else {
          Out.$out(/*KEEP_STR*/"<c++ method> ");
        }
        $out_raw_ostream_NamedDecl$C(Out, /*Deref*/D);
        // Print the parameters.
        Out.$out(/*KEEP_STR*/$LPAREN);
        boolean PrintComma = false;
        for (ParmVarDecl /*P*/ Parameter : D.parameters$Const()) {
          if (PrintComma) {
            Out.$out(/*KEEP_STR*/$COMMA_SPACE);
          } else {
            PrintComma = true;
          }
          $out_raw_ostream_NamedDecl$C(Out, /*Deref*/Parameter);
        }
        Out.$out(/*KEEP_STR*/$RPAREN);
        
        // Check the semantic DeclContext.
        /*const*/ DeclContext /*P*/ SemaDC = D.getDeclContext$Const();
        /*const*/ DeclContext /*P*/ LexicalDC = D.getLexicalDeclContext$Const();
        if (SemaDC != LexicalDC) {
          Out.$out(/*KEEP_STR*/" [[").$out(SemaDC).$out(/*KEEP_STR*/"]]");
        }
        
        break;
      }
     case CXXConstructor:
      {
        /*const*/ CXXConstructorDecl /*P*/ D = cast(CXXConstructorDecl.class, DC);
        if (D.isOutOfLine()) {
          Out.$out(/*KEEP_STR*/"[c++ ctor] ");
        } else if (D.isImplicit()) {
          Out.$out(/*KEEP_STR*/"(c++ ctor) ");
        } else {
          Out.$out(/*KEEP_STR*/"<c++ ctor> ");
        }
        $out_raw_ostream_NamedDecl$C(Out, /*Deref*/D);
        // Print the parameters.
        Out.$out(/*KEEP_STR*/$LPAREN);
        boolean PrintComma = false;
        for (ParmVarDecl /*P*/ Parameter : D.parameters$Const()) {
          if (PrintComma) {
            Out.$out(/*KEEP_STR*/$COMMA_SPACE);
          } else {
            PrintComma = true;
          }
          $out_raw_ostream_NamedDecl$C(Out, /*Deref*/Parameter);
        }
        Out.$out(/*KEEP_STR*/$RPAREN);
        
        // Check the semantic DC.
        /*const*/ DeclContext /*P*/ SemaDC = D.getDeclContext$Const();
        /*const*/ DeclContext /*P*/ LexicalDC = D.getLexicalDeclContext$Const();
        if (SemaDC != LexicalDC) {
          Out.$out(/*KEEP_STR*/" [[").$out(SemaDC).$out(/*KEEP_STR*/"]]");
        }
        break;
      }
     case CXXDestructor:
      {
        /*const*/ CXXDestructorDecl /*P*/ D = cast(CXXDestructorDecl.class, DC);
        if (D.isOutOfLine()) {
          Out.$out(/*KEEP_STR*/"[c++ dtor] ");
        } else if (D.isImplicit()) {
          Out.$out(/*KEEP_STR*/"(c++ dtor) ");
        } else {
          Out.$out(/*KEEP_STR*/"<c++ dtor> ");
        }
        $out_raw_ostream_NamedDecl$C(Out, /*Deref*/D);
        // Check the semantic DC.
        /*const*/ DeclContext /*P*/ SemaDC = D.getDeclContext$Const();
        /*const*/ DeclContext /*P*/ LexicalDC = D.getLexicalDeclContext$Const();
        if (SemaDC != LexicalDC) {
          Out.$out(/*KEEP_STR*/" [[").$out(SemaDC).$out(/*KEEP_STR*/"]]");
        }
        break;
      }
     case CXXConversion:
      {
        /*const*/ CXXConversionDecl /*P*/ D = cast(CXXConversionDecl.class, DC);
        if (D.isOutOfLine()) {
          Out.$out(/*KEEP_STR*/"[c++ conversion] ");
        } else if (D.isImplicit()) {
          Out.$out(/*KEEP_STR*/"(c++ conversion) ");
        } else {
          Out.$out(/*KEEP_STR*/"<c++ conversion> ");
        }
        $out_raw_ostream_NamedDecl$C(Out, /*Deref*/D);
        // Check the semantic DC.
        /*const*/ DeclContext /*P*/ SemaDC = D.getDeclContext$Const();
        /*const*/ DeclContext /*P*/ LexicalDC = D.getLexicalDeclContext$Const();
        if (SemaDC != LexicalDC) {
          Out.$out(/*KEEP_STR*/" [[").$out(SemaDC).$out(/*KEEP_STR*/"]]");
        }
        break;
      }
     default:
      throw new llvm_unreachable("a decl that inherits DeclContext isn't handled");
    }
    
    Out.$out(/*KEEP_STR*/$LF);
    
    // Print decls in the DeclContext.
    for (Decl /*P*/ I : DC.decls()) {
      for (/*uint*/int i = 0; $less_uint(i, Indentation); ++i)  {
        Out.$out(/*KEEP_STR*/"  ");
      }
      
      Decl.Kind DK = I.getKind();
      switch (DK) {
       case Namespace:
       case Enum:
       case Record:
       case CXXRecord:
       case ObjCMethod:
       case ObjCInterface:
       case ObjCCategory:
       case ObjCProtocol:
       case ObjCImplementation:
       case ObjCCategoryImpl:
       case LinkageSpec:
       case Block:
       case Function:
       case CXXMethod:
       case CXXConstructor:
       case CXXDestructor:
       case CXXConversion:
        {
          DeclContext /*P*/ _DC = cast(DeclContext.class, I);
          PrintDeclContext(_DC, Indentation + 2);
          break;
        }
       case IndirectField:
        {
          IndirectFieldDecl /*P*/ IFD = cast(IndirectFieldDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<IndirectField> "), /*Deref*/IFD).$out_char($$LF);
          break;
        }
       case Label:
        {
          LabelDecl /*P*/ LD = cast(LabelDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<Label> "), /*Deref*/LD).$out_char($$LF);
          break;
        }
       case Field:
        {
          FieldDecl /*P*/ FD = cast(FieldDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<field> "), /*Deref*/FD).$out_char($$LF);
          break;
        }
       case Typedef:
       case TypeAlias:
        {
          TypedefNameDecl /*P*/ TD = cast(TypedefNameDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<typedef> "), /*Deref*/TD).$out_char($$LF);
          break;
        }
       case EnumConstant:
        {
          EnumConstantDecl /*P*/ ECD = cast(EnumConstantDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<enum constant> "), /*Deref*/ECD).$out_char($$LF);
          break;
        }
       case Var:
        {
          VarDecl /*P*/ VD = cast(VarDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<var> "), /*Deref*/VD).$out_char($$LF);
          break;
        }
       case ImplicitParam:
        {
          ImplicitParamDecl /*P*/ IPD = cast(ImplicitParamDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<implicit parameter> "), /*Deref*/IPD).$out_char($$LF);
          break;
        }
       case ParmVar:
        {
          ParmVarDecl /*P*/ PVD = cast(ParmVarDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<parameter> "), /*Deref*/PVD).$out_char($$LF);
          break;
        }
       case ObjCProperty:
        {
          ObjCPropertyDecl /*P*/ OPD = cast(ObjCPropertyDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<objc property> "), /*Deref*/OPD).$out_char($$LF);
          break;
        }
       case FunctionTemplate:
        {
          FunctionTemplateDecl /*P*/ FTD = cast(FunctionTemplateDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<function template> "), /*Deref*/FTD).$out_char($$LF);
          break;
        }
       case FileScopeAsm:
        {
          Out.$out(/*KEEP_STR*/"<file-scope asm>\n");
          break;
        }
       case UsingDirective:
        {
          Out.$out(/*KEEP_STR*/"<using directive>\n");
          break;
        }
       case NamespaceAlias:
        {
          NamespaceAliasDecl /*P*/ NAD = cast(NamespaceAliasDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<namespace alias> "), /*Deref*/NAD).$out_char($$LF);
          break;
        }
       case ClassTemplate:
        {
          ClassTemplateDecl /*P*/ CTD = cast(ClassTemplateDecl.class, I);
          $out_raw_ostream_NamedDecl$C(Out.$out(/*KEEP_STR*/"<class template> "), /*Deref*/CTD).$out_char($$LF);
          break;
        }
       case OMPThreadPrivate:
        {
          Out.$out(/*KEEP_STR*/"<omp threadprivate> ").$out_char($$DBL_QUOTE).$out(I).$out(/*KEEP_STR*/$QUOTE_LF);
          break;
        }
       default:
        Out.$out(/*KEEP_STR*/"DeclKind: ").$out_int(DK.getValue()).$out_char($$DBL_QUOTE).$out(I).$out(/*KEEP_STR*/$QUOTE_LF);
        throw new llvm_unreachable("decl unhandled");
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclContextPrinter::~DeclContextPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 187,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 184,
   FQN="(anonymous namespace)::DeclContextPrinter::~DeclContextPrinter", NM="_ZN12_GLOBAL__N_118DeclContextPrinterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_118DeclContextPrinterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Out=" + Out // NOI18N
              + super.toString(); // NOI18N
  }
}
