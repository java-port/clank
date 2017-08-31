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
import org.llvm.support.*;
import org.clang.ast.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.serialization.*;
import org.clang.frontend.impl.*;


/// \brief Dumps deserialized declarations.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeserializedDeclsDumper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 81,
 FQN="(anonymous namespace)::DeserializedDeclsDumper", NM="_ZN12_GLOBAL__N_123DeserializedDeclsDumperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_123DeserializedDeclsDumperE")
//</editor-fold>
public class DeserializedDeclsDumper extends /*public*/ DelegatingDeserializationListener implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeserializedDeclsDumper::DeserializedDeclsDumper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 83,
   FQN="(anonymous namespace)::DeserializedDeclsDumper::DeserializedDeclsDumper", NM="_ZN12_GLOBAL__N_123DeserializedDeclsDumperC1EPN5clang26ASTDeserializationListenerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_123DeserializedDeclsDumperC1EPN5clang26ASTDeserializationListenerEb")
  //</editor-fold>
  public /*explicit*/ DeserializedDeclsDumper(ASTDeserializationListener /*P*/ Previous, 
      boolean DeletePrevious) {
    // : DelegatingDeserializationListener(Previous, DeletePrevious) 
    //START JInit
    super(Previous, DeletePrevious);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeserializedDeclsDumper::DeclRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 87,
   FQN="(anonymous namespace)::DeserializedDeclsDumper::DeclRead", NM="_ZN12_GLOBAL__N_123DeserializedDeclsDumper8DeclReadEjPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_123DeserializedDeclsDumper8DeclReadEjPKN5clang4DeclE")
  //</editor-fold>
  @Override public void DeclRead(/*uint32_t*/int ID, /*const*/ Decl /*P*/ D)/* override*/ {
    llvm.outs().$out(/*KEEP_STR*/"PCH DECL: ").$out(D.getDeclKindName());
    {
      /*const*/ NamedDecl /*P*/ ND = dyn_cast(NamedDecl.class, D);
      if ((ND != null)) {
        $out_raw_ostream_NamedDecl$C(llvm.outs().$out(/*KEEP_STR*/" - "), /*Deref*/ND);
      }
    }
    llvm.outs().$out(/*KEEP_STR*/$LF);
    
    super.DeclRead(ID, D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeserializedDeclsDumper::~DeserializedDeclsDumper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 81,
   FQN="(anonymous namespace)::DeserializedDeclsDumper::~DeserializedDeclsDumper", NM="_ZN12_GLOBAL__N_123DeserializedDeclsDumperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_123DeserializedDeclsDumperD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
