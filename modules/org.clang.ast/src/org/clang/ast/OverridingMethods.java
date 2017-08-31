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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clank.java.stdimpl.aliases.StdVector;


/// \brief The set of methods that override a given virtual method in
/// each subobject where it occurs.
///
/// The first part of the pair is the subobject in which the
/// overridden virtual function occurs, while the second part of the
/// pair is the virtual method that overrides it (including the
/// subobject in which that virtual function occurs).
//<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 270,
 FQN="clang::OverridingMethods", NM="_ZN5clang17OverridingMethodsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang17OverridingMethodsE")
//</editor-fold>
public class OverridingMethods implements Iterable<pairUIntType<SmallVector<UniqueVirtualMethod>>>, NativeCloneable<OverridingMethods>, Destructors.ClassWithDestructor {
  /*typedef SmallVector<UniqueVirtualMethod, 4> ValuesT*/
//  public final class ValuesT extends SmallVector<UniqueVirtualMethod>{ };
  /*typedef llvm::MapVector<unsigned int, ValuesT> MapType*/
//  public final class MapType extends MapVectorUIntType<SmallVector<UniqueVirtualMethod>>{ };
  private MapVectorUIntType<SmallVector<UniqueVirtualMethod>> Overrides;
/*public:*/
  // Iterate over the set of subobjects that have overriding methods.
  /*typedef MapType::iterator iterator*/
//  public final class iterator extends StdVector.iterator<std.pairUIntType<SmallVector<UniqueVirtualMethod>>>{ };
  /*typedef MapType::const_iterator const_iterator*/
//  public final class const_iterator extends StdVector.iterator<pairUIntType<SmallVector<UniqueVirtualMethod> > /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 279,
   FQN="clang::OverridingMethods::begin", NM="_ZN5clang17OverridingMethods5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang17OverridingMethods5beginEv")
  //</editor-fold>
  public StdVector.iterator<std.pairUIntType<SmallVector<UniqueVirtualMethod>>> begin() {
    return Overrides.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 280,
   FQN="clang::OverridingMethods::begin", NM="_ZNK5clang17OverridingMethods5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang17OverridingMethods5beginEv")
  //</editor-fold>
  public StdVector.iterator<pairUIntType<SmallVector<UniqueVirtualMethod> > /*P*/> begin$Const() /*const*/ {
    return Overrides.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 281,
   FQN="clang::OverridingMethods::end", NM="_ZN5clang17OverridingMethods3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang17OverridingMethods3endEv")
  //</editor-fold>
  public StdVector.iterator<std.pairUIntType<SmallVector<UniqueVirtualMethod>>> end() {
    return Overrides.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 282,
   FQN="clang::OverridingMethods::end", NM="_ZNK5clang17OverridingMethods3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang17OverridingMethods3endEv")
  //</editor-fold>
  public StdVector.iterator<pairUIntType<SmallVector<UniqueVirtualMethod> > /*P*/> end$Const() /*const*/ {
    return Overrides.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 283,
   FQN="clang::OverridingMethods::size", NM="_ZNK5clang17OverridingMethods4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZNK5clang17OverridingMethods4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Overrides.size();
  }

  
  // Iterate over the set of overriding virtual methods in a given
  // subobject.
  /*typedef SmallVectorImpl<UniqueVirtualMethod>::iterator overriding_iterator*/
//  public final class overriding_iterator extends type$ptr<UniqueVirtualMethod>{ };
  /*typedef SmallVectorImpl<UniqueVirtualMethod>::const_iterator overriding_const_iterator*/
//  public final class overriding_const_iterator extends type$ptr<UniqueVirtualMethod>{ };
  
  // Add a new overriding method for a particular subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::add">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$eq_ptr*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 442,
   FQN="clang::OverridingMethods::add", NM="_ZN5clang17OverridingMethods3addEjNS_19UniqueVirtualMethodE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang17OverridingMethods3addEjNS_19UniqueVirtualMethodE")
  //</editor-fold>
  public void add(/*uint*/int OverriddenSubobject, 
     UniqueVirtualMethod Overriding) {
    final SmallVectorImpl<UniqueVirtualMethod> /*&*/ SubobjectOverrides = Overrides.$at(OverriddenSubobject);
    if ($eq_ptr(std.find(SubobjectOverrides.begin(), SubobjectOverrides.end(), 
        Overriding), SubobjectOverrides.end())) {
      SubobjectOverrides.push_back(Overriding);
    }
  }

  
  // Add all of the overriding methods from "other" into overrides for
  // this method. Used when merging the overrides from multiple base
  // class subobjects.
  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 451,
   FQN="clang::OverridingMethods::add", NM="_ZN5clang17OverridingMethods3addERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang17OverridingMethods3addERKS0_")
  //</editor-fold>
  public void add(final /*const*/ OverridingMethods /*&*/ Other) {
    for (StdVector.iterator<pairUIntType<SmallVector<UniqueVirtualMethod> > /*P*/> I = Other.begin$Const(), IE = Other.end$Const(); $noteq___normal_iterator$C(I, IE); I.$preInc()) {
      for (type$ptr<UniqueVirtualMethod> M = $tryClone(I.$arrow().second.begin$Const()), 
          /*P*/ MEnd = $tryClone(I.$arrow().second.end$Const());
           $noteq_ptr(M, MEnd);
           M.$preInc())  {
        add(I.$arrow().first, new UniqueVirtualMethod(M.$star()));
      }
    }
  }

  
  // Replace all overriding virtual methods in all subobjects with the
  // given virtual method.
  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::replaceAll">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp", line = 461,
   FQN="clang::OverridingMethods::replaceAll", NM="_ZN5clang17OverridingMethods10replaceAllENS_19UniqueVirtualMethodE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang17OverridingMethods10replaceAllENS_19UniqueVirtualMethodE")
  //</editor-fold>
  public void replaceAll(UniqueVirtualMethod Overriding) {
    for (StdVector.iterator<std.pairUIntType<SmallVector<UniqueVirtualMethod>>> I = begin(), IEnd = end(); $noteq___normal_iterator$C(I, IEnd); I.$preInc()) {
      I.$arrow().second.clear();
      I.$arrow().second.push_back(Overriding);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::OverridingMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 270,
   FQN="clang::OverridingMethods::OverridingMethods", NM="_ZN5clang17OverridingMethodsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang17OverridingMethodsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ OverridingMethods(final /*const*/ OverridingMethods /*&*/ $Prm0) {
    // : Overrides(.Overrides) 
    //START JInit
    this.Overrides = new MapVectorUIntType<SmallVector<UniqueVirtualMethod>>($Prm0.Overrides);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::OverridingMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 270,
   FQN="clang::OverridingMethods::OverridingMethods", NM="_ZN5clang17OverridingMethodsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang17OverridingMethodsC1EOS0_")
  //</editor-fold>
  public /*inline*/ OverridingMethods(JD$Move _dparam, final OverridingMethods /*&&*/$Prm0) {
    // : Overrides(static_cast<OverridingMethods &&>().Overrides) 
    //START JInit
    this.Overrides = new MapVectorUIntType<SmallVector<UniqueVirtualMethod>>(JD$Move.INSTANCE, $Prm0.Overrides);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::~OverridingMethods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 270,
   FQN="clang::OverridingMethods::~OverridingMethods", NM="_ZN5clang17OverridingMethodsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang17OverridingMethodsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Overrides.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OverridingMethods::OverridingMethods">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*default value*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 270,
   FQN="clang::OverridingMethods::OverridingMethods", NM="_ZN5clang17OverridingMethodsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang17OverridingMethodsC1Ev")
  //</editor-fold>
  public /*inline*/ OverridingMethods() {
    // : Overrides() 
    //START JInit
    this.Overrides = new MapVectorUIntType<SmallVector<UniqueVirtualMethod>>(
            DenseMapInfoUInt.$Info(), 
            new SmallVector<UniqueVirtualMethod>(4, new UniqueVirtualMethod())
    );
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public java.util.Iterator<pairUIntType<SmallVector<UniqueVirtualMethod>>> iterator() {
    return new JavaIterator(begin(), end());
  }

  @Override
  public OverridingMethods clone() {
    return new OverridingMethods(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Overrides=" + Overrides; // NOI18N
  }
}
