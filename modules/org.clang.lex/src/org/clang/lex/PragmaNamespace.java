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

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// PragmaNamespace - This PragmaHandler subdivides the namespace of pragmas,
/// allowing hierarchical pragmas to be defined.  Common examples of namespaces
/// are "\#pragma GCC", "\#pragma STDC", and "\#pragma omp", but any namespaces
/// may be (potentially recursively) defined.
//<editor-fold defaultstate="collapsed" desc="clang::PragmaNamespace">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Pragma.h", line = 89,
 FQN = "clang::PragmaNamespace", NM = "_ZN5clang15PragmaNamespaceE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang15PragmaNamespaceE")
//</editor-fold>
public class PragmaNamespace extends /*public*/ PragmaHandler implements Destructors.ClassWithDestructor {
  /// Handlers - This is a map of the handlers in this namespace with their name
  /// as key.
  ///
  private StringMap<PragmaHandler /*P*//*, MallocAllocator*/> Handlers;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaNamespace::PragmaNamespace">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Pragma.h", line = 95,
   FQN = "clang::PragmaNamespace::PragmaNamespace", NM = "_ZN5clang15PragmaNamespaceC1EN4llvm9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang15PragmaNamespaceC1EN4llvm9StringRefE")
  //</editor-fold>
  public /*explicit*/ PragmaNamespace(StringRef Name) {
    /* : PragmaHandler(Name), Handlers()*/ 
    //START JInit
    super(Name);
    this.Handlers = new StringMap<PragmaHandler /*P*//*, MallocAllocator*/>(null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaNamespace::~PragmaNamespace">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 51,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 50,
   FQN = "clang::PragmaNamespace::~PragmaNamespace", NM = "_ZN5clang15PragmaNamespaceD0Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang15PragmaNamespaceD0Ev")
  //</editor-fold>
  @Override public void $destroy() {
    llvm.DeleteContainerSeconds(Handlers);
    //START JDestroy
    Handlers.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  /// FindHandler - Check to see if there is already a handler for the
  /// specified name.  If not, return the handler for the null name if it
  /// exists, otherwise return null.  If IgnoreNull is true (the default) then
  /// the null handler isn't returned on failure to match.
  
  /// FindHandler - Check to see if there is already a handler for the
  /// specified name.  If not, return the handler for the null identifier if it
  /// exists, otherwise return null.  If IgnoreNull is true (the default) then
  /// the null handler isn't returned on failure to match.
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaNamespace::FindHandler">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 59,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 58,
   FQN = "clang::PragmaNamespace::FindHandler", NM = "_ZNK5clang15PragmaNamespace11FindHandlerEN4llvm9StringRefEb",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZNK5clang15PragmaNamespace11FindHandlerEN4llvm9StringRefEb")
  //</editor-fold>
  public PragmaHandler /*P*/ FindHandler(StringRef Name) /*const*/ {
    return FindHandler(Name, true);
  }
  public PragmaHandler /*P*/ FindHandler(StringRef Name, boolean IgnoreNull/*= true*/) /*const*/ {
    {
      PragmaHandler /*P*/ Handler = Handlers.lookup(Name);
      if ((Handler != null)) {
        return Handler;
      }
    }
    return IgnoreNull ? null : Handlers.lookup(new StringRef());
  }

  
  /// AddPragma - Add a pragma to this namespace.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaNamespace::AddPragma">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 66,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 65,
   FQN = "clang::PragmaNamespace::AddPragma", NM = "_ZN5clang15PragmaNamespace9AddPragmaEPNS_13PragmaHandlerE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang15PragmaNamespace9AddPragmaEPNS_13PragmaHandlerE")
  //</editor-fold>
  public void AddPragma(PragmaHandler /*P*/ Handler) {
    assert (!(Handlers.lookup(Handler.getName()) != null)) : "A handler with this name is already registered in this namespace";
    Handlers.GetOrCreateValue(Handler.getName()).second = (Handler);
  }

  
  /// RemovePragmaHandler - Remove the given handler from the
  /// namespace.
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaNamespace::RemovePragmaHandler">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 72,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 71,
   FQN = "clang::PragmaNamespace::RemovePragmaHandler", NM = "_ZN5clang15PragmaNamespace19RemovePragmaHandlerEPNS_13PragmaHandlerE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang15PragmaNamespace19RemovePragmaHandlerEPNS_13PragmaHandlerE")
  //</editor-fold>
  public void RemovePragmaHandler(PragmaHandler /*P*/ Handler) {
    assert ((Handlers.lookup(Handler.getName()) != null)) : "Handler not registered in this namespace";
    Handlers.erase(Handler.getName());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaNamespace::IsEmpty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Pragma.h", line = 113,
   FQN = "clang::PragmaNamespace::IsEmpty", NM = "_ZN5clang15PragmaNamespace7IsEmptyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang15PragmaNamespace7IsEmptyEv")
  //</editor-fold>
  public boolean IsEmpty() {
    return Handlers.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaNamespace::HandlePragma">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", line = 78,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp", old_line = 77,
   FQN = "clang::PragmaNamespace::HandlePragma", NM = "_ZN5clang15PragmaNamespace12HandlePragmaERNS_12PreprocessorENS_20PragmaIntroducerKindERNS_5TokenE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang15PragmaNamespace12HandlePragmaERNS_12PreprocessorENS_20PragmaIntroducerKindERNS_5TokenE")
  //</editor-fold>
  @Override public void HandlePragma(Preprocessor /*&*/ PP, PragmaIntroducerKind Introducer, Token /*&*/ Tok) {
    // Read the 'namespace' that the directive is in, e.g. STDC.  Do not macro
    // expand it, the user can have a STDC #define, that should not affect this.
    PP.LexUnexpandedToken(Tok);
    
    // Get the handler for this token.  If there is no handler, ignore the pragma.
    PragmaHandler /*P*/ Handler = FindHandler((Tok.getIdentifierInfo() != null) ? Tok.getIdentifierInfo().getName() : new StringRef(), false);
    if (Handler == null) {
      PP.Diag(Tok, diag.warn_pragma_ignored).$destroy();
      return;
    }
    
    // Otherwise, pass it down.
    Handler.HandlePragma(PP, Introducer, Tok);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaNamespace::getIfNamespace">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/Pragma.h", line = 120,
   FQN = "clang::PragmaNamespace::getIfNamespace", NM = "_ZN5clang15PragmaNamespace14getIfNamespaceEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Pragma.cpp -nm=_ZN5clang15PragmaNamespace14getIfNamespaceEv")
  //</editor-fold>
  @Override public /*virtual*/ PragmaNamespace /*P*/ getIfNamespace() {
    return this;
  }

}
