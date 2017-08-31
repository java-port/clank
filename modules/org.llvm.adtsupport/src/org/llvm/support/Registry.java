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

package org.llvm.support;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.llvm.support.*;

/*template <typename T, typename U = RegistryTraits<T>> TEMPLATE*/

/// A global registry used in conjunction with static constructors to make
/// pluggable components (like targets or garbage collectors) "just work" when
/// linked with an executable.
//<editor-fold defaultstate="collapsed" desc="llvm::Registry">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 58,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 59,
 FQN = "llvm::Registry", NM = "_ZN4llvm8RegistryE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN4llvm8RegistryE")
//</editor-fold>
public class Registry</*typename*/ T>  {
  
  /// Node in linked list of entries.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Registry::node">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 61,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 64,
   FQN="llvm::Registry::node", NM="_ZN4llvm8Registry4nodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm8Registry4nodeE")
  //</editor-fold>
  public static class node<T> implements Native.NativeComparable<node<T>> {
    /*friend  class iterator*/
    /*friend  Registry<T>*/
    
    private node /*P*/ Next;
    private /*const*/ SimpleRegistryEntry<T> /*&*/ Val;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::Registry::node::node">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 69,
     FQN="llvm::Registry::node::node", NM="_ZN4llvm8Registry4nodeC1ERKNS_19SimpleRegistryEntryIT_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm8Registry4nodeC1ERKNS_19SimpleRegistryEntryIT_EE")
    //</editor-fold>
    public node(/*const*/ SimpleRegistryEntry<T> /*&*/ V) {
      /* : Next(null), Val(V)*/ 
      //START JInit
      this.Next = /*ParenListExpr*/null;
      this./*&*/Val=/*&*//*ParenListExpr*/V;
      //END JInit
    }

    
    public String toString() {
      return "" + "Next=" + Next // NOI18N
                + ", Val=" + Val; // NOI18N
    }

    @Override
    public boolean $eq(node<T> other) {
      return Native.$eq(Val, other.Val);
    }
  };
  
  /// Iterators for registry entries.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Registry::iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 82,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 66,
   FQN="llvm::Registry::iterator", NM="_ZN4llvm8Registry8iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm8Registry8iteratorE")
  //</editor-fold>
  public static class iterator<T> implements Native.NativeComparable<iterator<T>> {
    private /*const*/ node<T> /*P*/ Cur;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::Registry::iterator::iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 86,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 109,
     FQN="llvm::Registry::iterator::iterator", NM="_ZN4llvm8Registry8iteratorC1EPKNS0_4nodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm8Registry8iteratorC1EPKNS0_4nodeE")
    //</editor-fold>
    public /*explicit*/ iterator(/*const*/ node<T> /*P*/ N) {
      /* : Cur(N)*/ 
      //START JInit
      this.Cur = /*ParenListExpr*/N;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::Registry::iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 88,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 111,
     FQN="llvm::Registry::iterator::operator==", NM="_ZNK4llvm8Registry8iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm8Registry8iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(/*const*/ iterator<T> /*&*/ That) /*const*/ {
      return Native.$eq(Cur, That.Cur);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Registry::iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 89,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 112,
     FQN="llvm::Registry::iterator::operator!=", NM="_ZNK4llvm8Registry8iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm8Registry8iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(/*const*/ iterator<T> /*&*/ That) /*const*/ {
      return Native.$noteq(Cur, That.Cur);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Registry::iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 90,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 113,
     FQN="llvm::Registry::iterator::operator++", NM="_ZN4llvm8Registry8iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm8Registry8iteratorppEv")
    //</editor-fold>
    public iterator<T> /*&*/ $preInc() {
      Cur = Cur.Next;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Registry::iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 91,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 114,
     FQN="llvm::Registry::iterator::operator*", NM="_ZNK4llvm8Registry8iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm8Registry8iteratordeEv")
    //</editor-fold>
    public /*const*/ SimpleRegistryEntry<T> /*&*/ $star() /*const*/ {
      return Cur.Val;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Registry::iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 92,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 115,
     FQN="llvm::Registry::iterator::operator->", NM="_ZNK4llvm8Registry8iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm8Registry8iteratorptEv")
    //</editor-fold>
    public /*const*/ SimpleRegistryEntry<T> /*P*/ $arrow() /*const*/ {
      return $AddrOf(Cur.Val);
    }

    
    public String toString() {
      return "" + "Cur=" + Cur; // NOI18N
    }
  };
  
  // Since these are defined in a header file, plugins must be sure to export
  // these symbols.
  private node<T> /*P*/ Head;
  private node<T> /*P*/ Tail;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Registry::add_node">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 72,
   FQN="llvm::Registry::add_node", NM="_ZN4llvm8Registry8add_nodeEPNS0_4nodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm8Registry8add_nodeEPNS0_4nodeE")
  //</editor-fold>
  public void add_node(node /*P*/ N) {
    if (Tail != null) {
      Tail.Next = N;
    } else {
      Head = N;
    }
    Tail = N;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Registry::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 118,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 120,
   FQN = "llvm::Registry::begin", NM = "_ZN4llvm8Registry5beginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN4llvm8Registry5beginEv")
  //</editor-fold>
  protected iterator<T> begin_impl() {
    return new iterator(Head);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Registry::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", line = 119,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Registry.h", old_line = 121,
   FQN = "llvm::Registry::end", NM = "_ZN4llvm8Registry3endEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendAction.cpp -nm=_ZN4llvm8Registry3endEv")
  //</editor-fold>
  protected iterator<T> end_impl() {
    return new iterator(null);
  }

}
