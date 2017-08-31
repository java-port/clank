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

package org.clang.codegen.CodeGen;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;


/// CGCalleeInfo - Class to encapsulate the information about a callee to be
/// used during the generation of call/invoke instructions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCalleeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 669,
 FQN="clang::CodeGen::CGCalleeInfo", NM="_ZN5clang7CodeGen12CGCalleeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CGCalleeInfoE")
//</editor-fold>
public class CGCalleeInfo {
  /// \brief The function proto type of the callee.
  private /*const*/ FunctionProtoType /*P*/ CalleeProtoTy;
  /// \brief The function declaration of the callee.
  private /*const*/ Decl /*P*/ CalleeDecl;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCalleeInfo::CGCalleeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 676,
   FQN="clang::CodeGen::CGCalleeInfo::CGCalleeInfo", NM="_ZN5clang7CodeGen12CGCalleeInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CGCalleeInfoC1Ev")
  //</editor-fold>
  public /*explicit*/ CGCalleeInfo() {
    // : CalleeProtoTy(null), CalleeDecl(null) 
    //START JInit
    this.CalleeProtoTy = null;
    this.CalleeDecl = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCalleeInfo::CGCalleeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 677,
   FQN="clang::CodeGen::CGCalleeInfo::CGCalleeInfo", NM="_ZN5clang7CodeGen12CGCalleeInfoC1EPKNS_17FunctionProtoTypeEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CGCalleeInfoC1EPKNS_17FunctionProtoTypeEPKNS_4DeclE")
  //</editor-fold>
  public CGCalleeInfo(/*const*/ FunctionProtoType /*P*/ calleeProtoTy, /*const*/ Decl /*P*/ calleeDecl) {
    // : CalleeProtoTy(calleeProtoTy), CalleeDecl(calleeDecl) 
    //START JInit
    this.CalleeProtoTy = calleeProtoTy;
    this.CalleeDecl = calleeDecl;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCalleeInfo::CGCalleeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 679,
   FQN="clang::CodeGen::CGCalleeInfo::CGCalleeInfo", NM="_ZN5clang7CodeGen12CGCalleeInfoC1EPKNS_17FunctionProtoTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CGCalleeInfoC1EPKNS_17FunctionProtoTypeE")
  //</editor-fold>
  public CGCalleeInfo(/*const*/ FunctionProtoType /*P*/ calleeProtoTy) {
    // : CalleeProtoTy(calleeProtoTy), CalleeDecl(null) 
    //START JInit
    this.CalleeProtoTy = calleeProtoTy;
    this.CalleeDecl = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCalleeInfo::CGCalleeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 681,
   FQN="clang::CodeGen::CGCalleeInfo::CGCalleeInfo", NM="_ZN5clang7CodeGen12CGCalleeInfoC1EPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CGCalleeInfoC1EPKNS_4DeclE")
  //</editor-fold>
  public CGCalleeInfo(/*const*/ Decl /*P*/ calleeDecl) {
    // : CalleeProtoTy(null), CalleeDecl(calleeDecl) 
    //START JInit
    this.CalleeProtoTy = null;
    this.CalleeDecl = calleeDecl;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCalleeInfo::getCalleeFunctionProtoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 684,
   FQN="clang::CodeGen::CGCalleeInfo::getCalleeFunctionProtoType", NM="_ZN5clang7CodeGen12CGCalleeInfo26getCalleeFunctionProtoTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CGCalleeInfo26getCalleeFunctionProtoTypeEv")
  //</editor-fold>
  public /*const*/ FunctionProtoType /*P*/ getCalleeFunctionProtoType() {
    return CalleeProtoTy;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCalleeInfo::getCalleeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 687,
   FQN="clang::CodeGen::CGCalleeInfo::getCalleeDecl", NM="_ZN5clang7CodeGen12CGCalleeInfo13getCalleeDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CGCalleeInfo13getCalleeDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getCalleeDecl() {
    return CalleeDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCalleeInfo::CGCalleeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 669,
   FQN="clang::CodeGen::CGCalleeInfo::CGCalleeInfo", NM="_ZN5clang7CodeGen12CGCalleeInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CGCalleeInfoC1ERKS1_")
  //</editor-fold>
  public /*inline*/ CGCalleeInfo(final /*const*/ CGCalleeInfo /*&*/ $Prm0) {
    // : CalleeProtoTy(.CalleeProtoTy), CalleeDecl(.CalleeDecl) 
    //START JInit
    this.CalleeProtoTy = $Prm0.CalleeProtoTy;
    this.CalleeDecl = $Prm0.CalleeDecl;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGCalleeInfo::CGCalleeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/CGFunctionInfo.h", line = 669,
   FQN="clang::CodeGen::CGCalleeInfo::CGCalleeInfo", NM="_ZN5clang7CodeGen12CGCalleeInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen12CGCalleeInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ CGCalleeInfo(JD$Move _dparam, final CGCalleeInfo /*&&*/$Prm0) {
    // : CalleeProtoTy(static_cast<CGCalleeInfo &&>().CalleeProtoTy), CalleeDecl(static_cast<CGCalleeInfo &&>().CalleeDecl) 
    //START JInit
    this.CalleeProtoTy = $Prm0.CalleeProtoTy;
    this.CalleeDecl = $Prm0.CalleeDecl;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "CalleeProtoTy=" + CalleeProtoTy // NOI18N
              + ", CalleeDecl=" + "[Decl]"; // NOI18N
  }
}
