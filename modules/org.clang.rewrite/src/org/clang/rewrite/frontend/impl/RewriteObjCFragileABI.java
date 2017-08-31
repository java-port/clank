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

package org.clang.rewrite.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.rewrite.frontend.impl.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 507,
 FQN="(anonymous namespace)::RewriteObjCFragileABI", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABIE")
//</editor-fold>
public class RewriteObjCFragileABI extends /*public*/ RewriteObjC implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCFragileABI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 509,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCFragileABI", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABIC1ESsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EERN5clang17DiagnosticsEngineERKNS7_11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABIC1ESsSt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS3_EERN5clang17DiagnosticsEngineERKNS7_11LangOptionsEb")
  //</editor-fold>
  public RewriteObjCFragileABI(std.string inFile, std.unique_ptr<raw_ostream> OS, 
      DiagnosticsEngine /*&*/ D, /*const*/ LangOptions /*&*/ LOpts, 
      boolean silenceMacroWarn) {
    // : RewriteObjC(inFile, std::move(OS), D, LOpts, silenceMacroWarn) 
    /*ExprWithCleanups*/super(new std.string(inFile), new std.unique_ptr<raw_ostream>(JD$Move.INSTANCE, std.move(OS)), D, LOpts, silenceMacroWarn);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::~RewriteObjCFragileABI">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 514,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::~RewriteObjCFragileABI", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABID0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::Initialize">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 4942,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::Initialize", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABI10InitializeERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABI10InitializeERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void Initialize(ASTContext /*&*/ context)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Rewriting metadata
  /*template <typename MethodIterator> TEMPLATE*/
  
  // RewriteObjCMethodsMetaData - Rewrite methods metadata for instance or
  /// class methods.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCMethodsMetaData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 5730,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCMethodsMetaData", NM="Tpl__ZN12_GLOBAL__N_121RewriteObjCFragileABI26RewriteObjCMethodsMetaDataET_S1_bN4llvm9StringRefES3_RSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=Tpl__ZN12_GLOBAL__N_121RewriteObjCFragileABI26RewriteObjCMethodsMetaDataET_S1_bN4llvm9StringRefES3_RSs")
  //</editor-fold>
  public </*typename*/ MethodIterator> void RewriteObjCMethodsMetaData(MethodIterator MethodBegin, 
                            MethodIterator MethodEnd, 
                            boolean IsInstanceMethod, 
                            StringRef prefix, 
                            StringRef ClassName, 
                            std.string/*&*/ Result) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteObjCProtocolMetaData - Rewrite protocols meta-data.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCProtocolMetaData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 5077,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCProtocolMetaData", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABI27RewriteObjCProtocolMetaDataEPN5clang16ObjCProtocolDeclEN4llvm9StringRefES5_RSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABI27RewriteObjCProtocolMetaDataEPN5clang16ObjCProtocolDeclEN4llvm9StringRefES5_RSs")
  //</editor-fold>
  @Override public void RewriteObjCProtocolMetaData(ObjCProtocolDecl /*P*/ PDecl, StringRef prefix, 
                             StringRef ClassName, std.string/*&*/ Result)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCProtocolListMetaData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 5226,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCProtocolListMetaData", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABI31RewriteObjCProtocolListMetaDataERKN5clang8ObjCListINS1_16ObjCProtocolDeclEEEN4llvm9StringRefES8_RSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABI31RewriteObjCProtocolListMetaDataERKN5clang8ObjCListINS1_16ObjCProtocolDeclEEEN4llvm9StringRefES8_RSs")
  //</editor-fold>
  @Override public void RewriteObjCProtocolListMetaData(/*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Protocols, 
                                 StringRef prefix, StringRef ClassName, 
                                 std.string/*&*/ Result)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCClassMetaData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 5268,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCClassMetaData", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABI24RewriteObjCClassMetaDataEPN5clang22ObjCImplementationDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABI24RewriteObjCClassMetaDataEPN5clang22ObjCImplementationDeclERSs")
  //</editor-fold>
  @Override public void RewriteObjCClassMetaData(ObjCImplementationDecl /*P*/ IDecl, 
                          std.string/*&*/ Result)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::RewriteMetaDataIntoBuffer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 5523,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::RewriteMetaDataIntoBuffer", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABI25RewriteMetaDataIntoBufferERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABI25RewriteMetaDataIntoBufferERSs")
  //</editor-fold>
  @Override public void RewriteMetaDataIntoBuffer(std.string/*&*/ Result)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// RewriteObjCCategoryImplDecl - Rewrite metadata for each category
  /// implementation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 5621,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCCategoryImplDecl", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABI27RewriteObjCCategoryImplDeclEPN5clang20ObjCCategoryImplDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABI27RewriteObjCCategoryImplDeclEPN5clang20ObjCCategoryImplDeclERSs")
  //</editor-fold>
  @Override public void RewriteObjCCategoryImplDecl(ObjCCategoryImplDecl /*P*/ IDecl, 
                             std.string/*&*/ Result)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Rewriting ivar
  
  /// RewriteIvarOffsetComputation - This rutine synthesizes computation of
  /// ivar offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::RewriteIvarOffsetComputation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 5059,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::RewriteIvarOffsetComputation", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABI28RewriteIvarOffsetComputationEPN5clang12ObjCIvarDeclERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABI28RewriteIvarOffsetComputationEPN5clang12ObjCIvarDeclERSs")
  //</editor-fold>
  @Override public void RewriteIvarOffsetComputation(ObjCIvarDecl /*P*/ ivar, 
                              std.string/*&*/ Result)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 5801,
   FQN="(anonymous namespace)::RewriteObjCFragileABI::RewriteObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_121RewriteObjCFragileABI22RewriteObjCIvarRefExprEPN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZN12_GLOBAL__N_121RewriteObjCFragileABI22RewriteObjCIvarRefExprEPN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  @Override public Stmt /*P*/ RewriteObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ IV)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
