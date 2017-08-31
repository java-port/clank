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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.frontend.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 33,
 FQN="(anonymous namespace)::ASTPrinter", NM="_ZN12_GLOBAL__N_110ASTPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_110ASTPrinterE")
//</editor-fold>
public class ASTPrinter extends /*public*/ ASTConsumer implements /*public*/ RecursiveASTVisitor<ASTPrinter>, Destructors.ClassWithDestructor {
  /*typedef RecursiveASTVisitor<ASTPrinter> base*/
//  public final class base extends RecursiveASTVisitor<ASTPrinter>{ };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTPrinter::ASTPrinter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 38,
   FQN="(anonymous namespace)::ASTPrinter::ASTPrinter", NM="_ZN12_GLOBAL__N_110ASTPrinterC1ESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EEbNS2_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_110ASTPrinterC1ESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EEbNS2_9StringRefEb")
  //</editor-fold>
  public ASTPrinter() {
    this(new std.unique_ptr<raw_ostream>(JD$NullPtr.INSTANCE, null), false, 
      new StringRef(/*KEEP_STR*/$EMPTY), false);
  }
  public ASTPrinter(std.unique_ptr<raw_ostream> Out/*= null*/) {
    this(Out, false, 
      new StringRef(/*KEEP_STR*/$EMPTY), false);
  }
  public ASTPrinter(std.unique_ptr<raw_ostream> Out/*= null*/, boolean Dump/*= false*/) {
    this(Out, Dump, 
      new StringRef(/*KEEP_STR*/$EMPTY), false);
  }
  public ASTPrinter(std.unique_ptr<raw_ostream> Out/*= null*/, boolean Dump/*= false*/, 
      StringRef FilterString/*= ""*/) {
    this(Out, Dump, 
      FilterString, false);
  }
  public ASTPrinter(std.unique_ptr<raw_ostream> Out/*= null*/, boolean Dump/*= false*/, 
      StringRef FilterString/*= ""*/, boolean DumpLookups/*= false*/) {
    // : ASTConsumer(), RecursiveASTVisitor<ASTPrinter>(), Out(Out.operator bool() ? * Out : llvm::outs()), OwnedOut(std::move(Out)), Dump(Dump), FilterString(FilterString.operator basic_string()), DumpLookups(DumpLookups) 
    //START JInit
    super();
    $RecursiveASTVisitor();
    this./*&*/Out=/*&*/Out.$bool() ? Out.$star() : llvm.outs();
    this.OwnedOut = new std.unique_ptr<raw_ostream>(JD$Move.INSTANCE, std.move(Out));
    this.Dump = Dump;
    this.FilterString = FilterString.$string();
    this.DumpLookups = DumpLookups;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTPrinter::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 43,
   FQN="(anonymous namespace)::ASTPrinter::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_110ASTPrinter21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_110ASTPrinter21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(ASTContext /*&*/ Context)/* override*/ {
    TranslationUnitDecl /*P*/ D = Context.getTranslationUnitDecl();
    if (FilterString.empty()) {
      print(D);
      return;
    }
    
    TraverseDecl(D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTPrinter::shouldWalkTypesOfTypeLocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 52,
   FQN="(anonymous namespace)::ASTPrinter::shouldWalkTypesOfTypeLocs", NM="_ZNK12_GLOBAL__N_110ASTPrinter25shouldWalkTypesOfTypeLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZNK12_GLOBAL__N_110ASTPrinter25shouldWalkTypesOfTypeLocsEv")
  //</editor-fold>
  public boolean shouldWalkTypesOfTypeLocs() /*const*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTPrinter::TraverseDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 54,
   FQN="(anonymous namespace)::ASTPrinter::TraverseDecl", NM="_ZN12_GLOBAL__N_110ASTPrinter12TraverseDeclEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_110ASTPrinter12TraverseDeclEPN5clang4DeclE")
  //</editor-fold>
  public boolean TraverseDecl(Decl /*P*/ D) {
    if ((D != null) && filterMatches(D)) {
      boolean ShowColors = Out.has_colors();
      if (ShowColors) {
        Out.changeColor(raw_ostream.Colors.BLUE);
      }
      Out.$out(((Dump || DumpLookups) ? $("Dumping ") : $("Printing "))).$out(getName(D)).$out(
          /*KEEP_STR*/$COLON_LF
      );
      if (ShowColors) {
        Out.resetColor();
      }
      print(D);
      Out.$out(/*KEEP_STR*/$LF);
      // Don't traverse child nodes to avoid output duplication.
      return true;
    }
    return RecursiveASTVisitor.super.TraverseDecl(D);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTPrinter::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 72,
   FQN="(anonymous namespace)::ASTPrinter::getName", NM="_ZN12_GLOBAL__N_110ASTPrinter7getNameEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_110ASTPrinter7getNameEPN5clang4DeclE")
  //</editor-fold>
  private std.string getName(Decl /*P*/ D) {
    if (isa(NamedDecl.class, D)) {
      return cast(NamedDecl.class, D).getQualifiedNameAsString();
    }
    return new std.string(/*KEEP_STR*/$EMPTY);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTPrinter::filterMatches">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 77,
   FQN="(anonymous namespace)::ASTPrinter::filterMatches", NM="_ZN12_GLOBAL__N_110ASTPrinter13filterMatchesEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_110ASTPrinter13filterMatchesEPN5clang4DeclE")
  //</editor-fold>
  private boolean filterMatches(Decl /*P*/ D) {
    return getName(D).find(FilterString) != std.string.npos;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTPrinter::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 80,
   FQN="(anonymous namespace)::ASTPrinter::print", NM="_ZN12_GLOBAL__N_110ASTPrinter5printEPN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_110ASTPrinter5printEPN5clang4DeclE")
  //</editor-fold>
  private void print(Decl /*P*/ D) {
    if (DumpLookups) {
      {
        DeclContext /*P*/ DC = dyn_cast(DeclContext.class, D);
        if ((DC != null)) {
          if (DC == DC.getPrimaryContext()) {
            DC.dumpLookups(Out, Dump);
          } else {
            Out.$out(/*KEEP_STR*/"Lookup map is in primary DeclContext ").$out(
                DC.getPrimaryContext()
            ).$out(/*KEEP_STR*/$LF);
          }
        } else {
          Out.$out(/*KEEP_STR*/"Not a DeclContext\n");
        }
      }
    } else if (Dump) {
      D.dump(Out);
    } else {
      D.print(Out, /*Indentation=*/ 0, /*PrintInstantiation=*/ true);
    }
  }

  
  private raw_ostream /*&*/ Out;
  private std.unique_ptr<raw_ostream> OwnedOut;
  private boolean Dump;
  private std.string FilterString;
  private boolean DumpLookups;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ASTPrinter::~ASTPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 33,
   FQN="(anonymous namespace)::ASTPrinter::~ASTPrinter", NM="_ZN12_GLOBAL__N_110ASTPrinterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN12_GLOBAL__N_110ASTPrinterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    FilterString.$destroy();
    OwnedOut.$destroy();
    super.$destroy();
    //~RecursiveASTVisitor<ASTPrinter>;
    //END JDestroy
  }

  @Override
  public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
    // no any overridden traverse with queue methods
    return false;
  }
  
  @Override public String toString() {
    return "" + "Out=" + Out // NOI18N
              + ", OwnedOut=" + OwnedOut // NOI18N
              + ", Dump=" + Dump // NOI18N
              + ", FilterString=" + FilterString // NOI18N
              + ", DumpLookups=" + DumpLookups // NOI18N
              + super.toString(); // NOI18N
  }
}
