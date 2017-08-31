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

package org.clang.sema;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;


/// \brief A class for storing results from argument-dependent lookup.
//<editor-fold defaultstate="collapsed" desc="clang::ADLResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 769,
 FQN="clang::ADLResult", NM="_ZN5clang9ADLResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang9ADLResultE")
//</editor-fold>
public class ADLResult implements Destructors.ClassWithDestructor {
/*private:*/
  /// A map from canonical decls to the 'most recent' decl.
  private MapVectorPtrPtr<NamedDecl /*P*/ , NamedDecl /*P*/ > Decls;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ADLResult::select_second">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 774,
   FQN="clang::ADLResult::select_second", NM="_ZN5clang9ADLResult13select_secondE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang9ADLResult13select_secondE")
  //</editor-fold>
  private static class/*struct*/ select_second implements Converter<std.pairPtrPtr<NamedDecl /*P*/ , NamedDecl /*P*/ >, NamedDecl /*P*/> {
    //<editor-fold defaultstate="collapsed" desc="clang::ADLResult::select_second::operator()">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 775,
     FQN="clang::ADLResult::select_second::operator()", NM="_ZNK5clang9ADLResult13select_secondclESt4pairIPNS_9NamedDeclES4_E",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang9ADLResult13select_secondclESt4pairIPNS_9NamedDeclES4_E")
    //</editor-fold>
    public NamedDecl /*P*/ $call(std.pairPtrPtr<NamedDecl /*P*/ , NamedDecl /*P*/ > P) /*const*/ {
      return P.second;
    }
  };
/*public:*/
  /// Adds a new ADL candidate to this map.
  //<editor-fold defaultstate="collapsed" desc="clang::ADLResult::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 3222,
   FQN="clang::ADLResult::insert", NM="_ZN5clang9ADLResult6insertEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang9ADLResult6insertEPNS_9NamedDeclE")
  //</editor-fold>
  public void insert(NamedDecl /*P*/ New) {
    final type$ref<NamedDecl /*P*/> Old = Decls.ref$at(cast(NamedDecl.class, New.getCanonicalDecl()));
    
    // If we haven't yet seen a decl for this key, or the last decl
    // was exactly this one, we're done.
    if (Old.$deref() == null || Old.$deref() == New) {
      Old.$set(New);
      return;
    }
    
    // Otherwise, decide which is a more recent redeclaration.
    FunctionDecl /*P*/ OldFD = Old.$deref().getAsFunction();
    FunctionDecl /*P*/ NewFD = New.getAsFunction();
    
    FunctionDecl /*P*/ Cursor = NewFD;
    while (true) {
      Cursor = Cursor.getPreviousDecl();
      
      // If we got to the end without finding OldFD, OldFD is the newer
      // declaration;  leave things as they are.
      if (!(Cursor != null)) {
        return;
      }
      
      // If we do find OldFD, then NewFD is newer.
      if (Cursor == OldFD) {
        break;
      }
      // Otherwise, keep looking.
    }
    
    Old.$set(New);
  }

  
  /// Removes any data associated with a given decl.
  //<editor-fold defaultstate="collapsed" desc="clang::ADLResult::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 785,
   FQN="clang::ADLResult::erase", NM="_ZN5clang9ADLResult5eraseEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang9ADLResult5eraseEPNS_9NamedDeclE")
  //</editor-fold>
  public void erase(NamedDecl /*P*/ D) {
    Decls.erase(cast(NamedDecl.class, D.getCanonicalDecl()));
  }

  
  /*typedef llvm::mapped_iterator<decltype(Decls)::iterator, select_second> iterator*/
//  public final class iterator extends mapped_iterator<StdVector.iterator<pair<NamedDecl /*P*/ , NamedDecl /*P*/ >>, select_second>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ADLResult::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 792,
   FQN="clang::ADLResult::begin", NM="_ZN5clang9ADLResult5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang9ADLResult5beginEv")
  //</editor-fold>
  public mapped_iterator<pairPtrPtr<NamedDecl /*P*/ , NamedDecl /*P*/ >, NamedDecl /*P*/> begin() {
    return new mapped_iterator(Decls.begin(), new select_second());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ADLResult::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 793,
   FQN="clang::ADLResult::end", NM="_ZN5clang9ADLResult3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang9ADLResult3endEv")
  //</editor-fold>
  public mapped_iterator<pairPtrPtr<NamedDecl /*P*/ , NamedDecl /*P*/ >, NamedDecl /*P*/> end() {
    return new mapped_iterator<pairPtrPtr<NamedDecl /*P*/ , NamedDecl /*P*/ >, NamedDecl /*P*/>(Decls.end(), new select_second());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ADLResult::ADLResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 769,
   FQN="clang::ADLResult::ADLResult", NM="_ZN5clang9ADLResultC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang9ADLResultC1Ev")
  //</editor-fold>
  public /*inline*/ ADLResult() {
    // : Decls() 
    //START JInit
    this.Decls = new MapVectorPtrPtr<NamedDecl /*P*/ , NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (NamedDecl/*P*/)null);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ADLResult::~ADLResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Lookup.h", line = 769,
   FQN="clang::ADLResult::~ADLResult", NM="_ZN5clang9ADLResultD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang9ADLResultD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Decls.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Decls=" + Decls; // NOI18N
  }
}
