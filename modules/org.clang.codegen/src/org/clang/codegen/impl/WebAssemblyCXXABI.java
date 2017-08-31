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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.isa_CXXConstructorDecl;
import static org.clang.ast.java.AstDeclarationsRTTI.isa_CXXDestructorDecl;
import org.clang.basic.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyCXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 434,
 FQN="(anonymous namespace)::WebAssemblyCXXABI", NM="_ZN12_GLOBAL__N_117WebAssemblyCXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_117WebAssemblyCXXABIE")
//</editor-fold>
public final class WebAssemblyCXXABI extends /*public*/ ItaniumCXXABI implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyCXXABI::WebAssemblyCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 436,
   FQN="(anonymous namespace)::WebAssemblyCXXABI::WebAssemblyCXXABI", NM="_ZN12_GLOBAL__N_117WebAssemblyCXXABIC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_117WebAssemblyCXXABIC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public /*explicit*/ WebAssemblyCXXABI(final CodeGenModule /*&*/ CGM) {
    // : ItaniumCXXABI(CGM, /*UseARMMethodPtrABI=*/ true, /*UseARMGuardVarABI=*/ true) 
    //START JInit
    super(CGM, true, 
        true);
    //END JInit
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyCXXABI::HasThisReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 441,
   FQN="(anonymous namespace)::WebAssemblyCXXABI::HasThisReturn", NM="_ZNK12_GLOBAL__N_117WebAssemblyCXXABI13HasThisReturnEN5clang10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_117WebAssemblyCXXABI13HasThisReturnEN5clang10GlobalDeclE")
  //</editor-fold>
  @Override public/*private*/ boolean HasThisReturn(GlobalDecl GD) /*const*//* override*/ {
    return isa_CXXConstructorDecl(GD.getDecl())
       || (isa_CXXDestructorDecl(GD.getDecl())
       && GD.getDtorType() != CXXDtorType.Dtor_Deleting);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyCXXABI::canCallMismatchedFunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 446,
   FQN="(anonymous namespace)::WebAssemblyCXXABI::canCallMismatchedFunctionType", NM="_ZNK12_GLOBAL__N_117WebAssemblyCXXABI29canCallMismatchedFunctionTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_117WebAssemblyCXXABI29canCallMismatchedFunctionTypeEv")
  //</editor-fold>
  @Override public/*private*/ boolean canCallMismatchedFunctionType() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyCXXABI::~WebAssemblyCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 434,
   FQN="(anonymous namespace)::WebAssemblyCXXABI::~WebAssemblyCXXABI", NM="_ZN12_GLOBAL__N_117WebAssemblyCXXABID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_117WebAssemblyCXXABID0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
