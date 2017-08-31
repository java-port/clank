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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.serialization.*;
import org.clang.frontend.impl.*;


/// \brief Checks deserialized declarations and emits error if a name
/// matches one given in command-line using -error-on-deserialized-decl.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeserializedDeclsChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 99,
 FQN="(anonymous namespace)::DeserializedDeclsChecker", NM="_ZN12_GLOBAL__N_124DeserializedDeclsCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_124DeserializedDeclsCheckerE")
//</editor-fold>
public class DeserializedDeclsChecker extends /*public*/ DelegatingDeserializationListener implements Destructors.ClassWithDestructor {
  private ASTContext /*&*/ Ctx;
  private std.setType<std.string> NamesToCheck;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeserializedDeclsChecker::DeserializedDeclsChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 104,
   FQN="(anonymous namespace)::DeserializedDeclsChecker::DeserializedDeclsChecker", NM="_ZN12_GLOBAL__N_124DeserializedDeclsCheckerC1ERN5clang10ASTContextERKSt3setISsSt4lessISsESaISsEEPNS1_26ASTDeserializationListenerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_124DeserializedDeclsCheckerC1ERN5clang10ASTContextERKSt3setISsSt4lessISsESaISsEEPNS1_26ASTDeserializationListenerEb")
  //</editor-fold>
  public DeserializedDeclsChecker(ASTContext /*&*/ Ctx, 
      /*const*/ std.setType<std.string> /*&*/ NamesToCheck, 
      ASTDeserializationListener /*P*/ Previous, 
      boolean DeletePrevious) {
    // : DelegatingDeserializationListener(Previous, DeletePrevious), Ctx(Ctx), NamesToCheck(NamesToCheck) 
    //START JInit
    super(Previous, DeletePrevious);
    this./*&*/Ctx=/*&*/Ctx;
    this.NamesToCheck = new std.setType<std.string>(NamesToCheck);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeserializedDeclsChecker::DeclRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 111,
   FQN="(anonymous namespace)::DeserializedDeclsChecker::DeclRead", NM="_ZN12_GLOBAL__N_124DeserializedDeclsChecker8DeclReadEjPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_124DeserializedDeclsChecker8DeclReadEjPKN5clang4DeclE")
  //</editor-fold>
  @Override public void DeclRead(/*uint32_t*/int ID, /*const*/ Decl /*P*/ D)/* override*/ {
    {
      /*const*/ NamedDecl /*P*/ ND = dyn_cast(NamedDecl.class, D);
      if ((ND != null)) {
        if (NamesToCheck.find(ND.getNameAsString()).$noteq(NamesToCheck.end())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int DiagID = Ctx.getDiagnostics().getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
                /*KEEP_STR*/"%0 was deserialized");
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Ctx.getDiagnostics().Report(/*NO_COPY*/Ctx.getFullLoc(D.getLocation()), DiagID)), 
                new StringRef(ND.getNameAsString())));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    super.DeclRead(ID, D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeserializedDeclsChecker::~DeserializedDeclsChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp", line = 99,
   FQN="(anonymous namespace)::DeserializedDeclsChecker::~DeserializedDeclsChecker", NM="_ZN12_GLOBAL__N_124DeserializedDeclsCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN12_GLOBAL__N_124DeserializedDeclsCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    NamesToCheck.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Ctx=" + Ctx // NOI18N
              + ", NamesToCheck=" + NamesToCheck // NOI18N
              + super.toString(); // NOI18N
  }
}
