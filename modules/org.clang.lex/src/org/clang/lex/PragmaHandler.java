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

package org.clang.lex;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;


/// PragmaHandler - Instances of this interface defined to handle the various
/// pragmas that the language front-end uses.  Each handler optionally has a
/// name (e.g. "pack") and the HandlePragma method is invoked when a pragma with
/// that identifier is found.  If a handler does not match any of the declared
/// pragmas the handler with a null identifier is invoked, if it exists.
///
/// Note that the PragmaNamespace class can be used to subdivide pragmas, e.g.
/// we treat "\#pragma STDC" and "\#pragma GCC" as namespaces that contain other
/// pragmas.
//<editor-fold defaultstate="collapsed" desc="clang::PragmaHandler">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Pragma.h", line = 59,
 FQN = "clang::PragmaHandler", NM = "_ZN5clang13PragmaHandlerE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang13PragmaHandlerE")
//</editor-fold>
public abstract class PragmaHandler implements Destructors.ClassWithDestructor {
  private std.string Name;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaHandler::PragmaHandler">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Pragma.h", line = 62,
   FQN = "clang::PragmaHandler::PragmaHandler", NM = "_ZN5clang13PragmaHandlerC1EN4llvm9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang13PragmaHandlerC1EN4llvm9StringRefE")
  //</editor-fold>
  public /*explicit*/ PragmaHandler(char$ptr name) {
    this(new StringRef(name));
  }
  public /*explicit*/ PragmaHandler(String name) {
    this(new StringRef(name));
  }
  public /*explicit*/ PragmaHandler(StringRef name) {
    /* : Name(name.operator basic_string())*/ 
    //START JInit
    this.Name = name.$string();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaHandler::PragmaHandler">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Pragma.h", line = 63,
   FQN = "clang::PragmaHandler::PragmaHandler", NM = "_ZN5clang13PragmaHandlerC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang13PragmaHandlerC1Ev")
  //</editor-fold>
  public PragmaHandler() {
    /* : Name()*/ 
    //START JInit
    this.Name = new std.string();
    //END JInit
  }

  
  // Out-of-line destructor to provide a home for the class.
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaHandler::~PragmaHandler">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 34,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 33,
   FQN = "clang::PragmaHandler::~PragmaHandler", NM = "_ZN5clang13PragmaHandlerD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang13PragmaHandlerD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaHandler::getName">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Pragma.h", line = 66,
   FQN = "clang::PragmaHandler::getName", NM = "_ZNK5clang13PragmaHandler7getNameEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZNK5clang13PragmaHandler7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(Name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaHandler::HandlePragma">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Pragma.h", line = 67,
   FQN = "clang::PragmaHandler::HandlePragma", NM = "_ZN5clang13PragmaHandler12HandlePragmaERNS_12PreprocessorENS_20PragmaIntroducerKindERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang13PragmaHandler12HandlePragmaERNS_12PreprocessorENS_20PragmaIntroducerKindERNS_5TokenE")
  //</editor-fold>
  public abstract /*virtual*/ void HandlePragma(Preprocessor /*&*/ PP, PragmaIntroducerKind Introducer, Token /*&*/ FirstToken)/* = 0*/;

  
  /// getIfNamespace - If this is a namespace, return it.  This is equivalent to
  /// using a dynamic_cast, but doesn't require RTTI.
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaHandler::getIfNamespace">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Pragma.h", line = 72,
   FQN = "clang::PragmaHandler::getIfNamespace", NM = "_ZN5clang13PragmaHandler14getIfNamespaceEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang13PragmaHandler14getIfNamespaceEv")
  //</editor-fold>
  public /*virtual*/ PragmaNamespace /*P*/ getIfNamespace() {
    return null;
  }

}
