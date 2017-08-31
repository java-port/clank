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
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;


/// A metaprogramming base class for TypeLoc classes which correspond
/// to a particular Type subclass.  It is accepted for a single
/// TypeLoc class to correspond to multiple Type classes.
///
/// \tparam Base a class from which to derive
/// \tparam Derived the class deriving from this one
/// \tparam TypeClass the concrete Type subclass associated with this
///   location type
/// \tparam LocalData the structure type of local location data for
///   this type
///
/// TypeLocs with non-constant amounts of local data should override
/// getExtraLocalDataSize(); getExtraLocalData() will then point to
/// this extra memory.
///
/// TypeLocs with an inner type should define
///   QualType getInnerType() const
/// and getInnerTypeLoc() will then point to this inner type's
/// location data.
///
/// A word about hierarchies: this template is not designed to be
/// derived from multiple times in a hierarchy.  It is also not
/// designed to be used for classes where subtypes might provide
/// different amounts of source information.  It should be subclassed
/// only at the deepest portion of the hierarchy where all children
/// have identical source information; if that's an abstract type,
/// then further descendents should inherit from
/// InheritingConcreteTypeLoc instead.
/*template <class Base, class Derived, class TypeClass, class LocalData> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*used as specialization for ConcreteTypeLoc<UnqualTypeLoc, ...>*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 331,
 FQN="clang::ConcreteTypeLoc", NM="_ZN5clang15ConcreteTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15ConcreteTypeLocE")
//</editor-fold>
public abstract class Concrete$UnqualTypeLoc</*class Base, *//*class*/ Derived extends Concrete$UnqualTypeLoc, /*class*/ TypeClass extends Type, /*class*/ LocalData>  extends UnqualTypeLoc<TypeClass>/*extends own template param public Base*/ {
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected Concrete$UnqualTypeLoc() {
    // "replacemethod for super() called in derived class");
    super();
  }
  protected Concrete$UnqualTypeLoc(Derived $Prm0) {
    // "replacemethod for super-copy() called in derived class");
    super($Prm0);
  }
  protected Concrete$UnqualTypeLoc(JD$Move _dparam, Derived $Prm0) {
    // "replacemethod for super-move() called in derived class");
    super(_dparam, $Prm0);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::asDerived">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 334,
   FQN="clang::ConcreteTypeLoc::asDerived", NM="_ZNK5clang15ConcreteTypeLoc9asDerivedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc9asDerivedEv")
  //</editor-fold>
  private /*const*/ Derived /*P*/ asDerived() /*const*/ {
    return ((/*static_cast*//*const*/ Derived /*P*/ )(this));
  }

  
  /*friend  class TypeLoc*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::isKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 339,
   FQN="clang::ConcreteTypeLoc::isKind", NM="_ZN5clang15ConcreteTypeLoc6isKindERKNS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15ConcreteTypeLoc6isKindERKNS_7TypeLocE")
  //</editor-fold>
  /*friend*//*private*/ static boolean isKind(/*const*/ TypeLoc /*&*/ TL) {
//    if (TL.getType().hasLocalQualifiers()) {
//      return false;
//    }
//       && Derived.classofType(TL.getTypePtr());
    throw new UnsupportedOperationException("TypeLoc.isKind should be used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::classofType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 344,
   FQN="clang::ConcreteTypeLoc::classofType", NM="_ZN5clang15ConcreteTypeLoc11classofTypeEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15ConcreteTypeLoc11classofTypeEPKNS_4TypeE")
  //</editor-fold>
  /*friend*//*private*/ static boolean classofType(/*const*/ Type /*P*/ Ty) {
//    return TypeClass::classof(Ty);
    throw new UnsupportedOperationException("used through TypeLoc.isKind");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getLocalDataAlignment">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 349,
   FQN="clang::ConcreteTypeLoc::getLocalDataAlignment", NM="_ZNK5clang15ConcreteTypeLoc21getLocalDataAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc21getLocalDataAlignmentEv")
  //</editor-fold>
  public /*uint*/int getLocalDataAlignment() /*const*/ {
    return std.max($alignOf_LocalData(), 
        asDerived().getExtraLocalDataAlignment());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getLocalDataSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 353,
   FQN="clang::ConcreteTypeLoc::getLocalDataSize", NM="_ZNK5clang15ConcreteTypeLoc16getLocalDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getLocalDataSizeEv")
  //</editor-fold>
  public /*uint*/int getLocalDataSize() /*const*/ {
    /*uint*/int size = $sizeof_LocalData();
    /*uint*/int extraAlign = asDerived().getExtraLocalDataAlignment();
    size = $ulong2uint(llvm.alignTo($uint2ulong(size), $uint2ulong(extraAlign)));
    size += asDerived().getExtraLocalDataSize();
    return size;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::copyLocal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 361,
   FQN="clang::ConcreteTypeLoc::copyLocal", NM="_ZN5clang15ConcreteTypeLoc9copyLocalET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15ConcreteTypeLoc9copyLocalET0_")
  //</editor-fold>
  public void copyLocal(Derived other) {
    // Some subclasses have no data to copy.
    if (Native.$eq(asDerived().getLocalDataSize(), 0)) {
      return;
    }
    
    // Copy the fixed-sized local data.
    memcpy(getLocalData$Ptr(), other.getLocalData$Ptr(), $sizeof_LocalData());
    
    // Copy the variable-sized local data. We need to do this
    // separately because the padding in the source and the padding in
    // the destination might be different.
    memcpy(getExtraLocalData(), other.getExtraLocalData(), 
        asDerived().getExtraLocalDataSize());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 375,
   FQN="clang::ConcreteTypeLoc::getNextTypeLoc", NM="_ZNK5clang15ConcreteTypeLoc14getNextTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc14getNextTypeLocEv")
  //</editor-fold>
  public TypeLoc getNextTypeLoc() /*const*/ {
    return getNextTypeLoc(asDerived().getInnerType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getTypePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 379,
   FQN="clang::ConcreteTypeLoc::getTypePtr", NM="_ZNK5clang15ConcreteTypeLoc10getTypePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc10getTypePtrEv")
  //</editor-fold>
  public /*const*/ TypeClass /*P*/ getTypePtr() /*const*/ {
    return cast(getTypeClass(), super.getTypePtr());
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getExtraLocalDataSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 384,
   FQN="clang::ConcreteTypeLoc::getExtraLocalDataSize", NM="_ZNK5clang15ConcreteTypeLoc21getExtraLocalDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc21getExtraLocalDataSizeEv")
  //</editor-fold>
  protected /*uint*/int getExtraLocalDataSize() /*const*/ {
    return 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getExtraLocalDataAlignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 388,
   FQN="clang::ConcreteTypeLoc::getExtraLocalDataAlignment", NM="_ZNK5clang15ConcreteTypeLoc26getExtraLocalDataAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc26getExtraLocalDataAlignmentEv")
  //</editor-fold>
  protected /*uint*/int getExtraLocalDataAlignment() /*const*/ {
    return 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getLocalData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 392,
   FQN="clang::ConcreteTypeLoc::getLocalData", NM="_ZNK5clang15ConcreteTypeLoc12getLocalDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc12getLocalDataEv")
  //</editor-fold>
  protected LocalData /*P*/ getLocalData() /*const*/ {
    return getLocalData$Ptr().$star();
  }
  protected type$ptr<LocalData /*P*/> getLocalData$Ptr() /*const*/ {
    return ((/*static_cast*/type$ptr<LocalData /*P*/> )(super.Data));
  }

  
  /// Gets a pointer past the Info structure; useful for classes with
  /// local data that can't be captured in the Info (e.g. because it's
  /// of variable size).
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getExtraLocalData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 399,
   FQN="clang::ConcreteTypeLoc::getExtraLocalData", NM="_ZNK5clang15ConcreteTypeLoc17getExtraLocalDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc17getExtraLocalDataEv")
  //</editor-fold>
  protected type$ptr<?>/*void P*/ getExtraLocalData() /*const*/ {
    /*uint*/int size = $sizeof_LocalData();
    /*uint*/int extraAlign = asDerived().getExtraLocalDataAlignment();
    size = $ulong2uint(llvm.alignTo($uint2ulong(size), $uint2ulong(extraAlign)));
    assert size == 1 : "in Java Local Data occupies one element ";
    return ((type$ptr<?>)reinterpret_cast(type$ptr/*char P*/ .class, super.Data)).$add(size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNonLocalData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 406,
   FQN="clang::ConcreteTypeLoc::getNonLocalData", NM="_ZNK5clang15ConcreteTypeLoc15getNonLocalDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc15getNonLocalDataEv")
  //</editor-fold>
  protected type$ptr<?>/*void P*/ getNonLocalData() /*const*/ {
    if (super.Data == null) {
      return null;
    }
    type$ptr<?>/*uintptr_t*/ data = $tryClone((type$ptr<?>)reinterpret_cast_Object/*uintptr_t*/(super.Data));
    data.$inc(asDerived().getLocalDataSize());
    data = llvm.alignTo(data, getNextTypeAlign());
    return (type$ptr<?>)reinterpret_cast(Object/*void P*/ .class, data);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::HasNoInnerType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*HasNoInnerType extends QualType*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 413,
   FQN="clang::ConcreteTypeLoc::HasNoInnerType", NM="_ZN5clang15ConcreteTypeLoc14HasNoInnerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15ConcreteTypeLoc14HasNoInnerTypeE")
  //</editor-fold>
  protected static final class/*struct*/ HasNoInnerType extends QualType {
    protected static final HasNoInnerType INSTANCE = new HasNoInnerType();
    private HasNoInnerType() { super(); }
    
    // I makde it extend QualType since otherwise we have lots of problem in derived classes    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getInnerType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*HasNoInnerType=>QualType*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 414,
   FQN="clang::ConcreteTypeLoc::getInnerType", NM="_ZNK5clang15ConcreteTypeLoc12getInnerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc12getInnerTypeEv")
  //</editor-fold>
  protected QualType/*HasNoInnerType*/ getInnerType() /*const*/ {
    // I makde it extend return QualType since otherwise we have lots of problem in derived classes
    return HasNoInnerType.INSTANCE;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getInnerTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 416,
   FQN="clang::ConcreteTypeLoc::getInnerTypeLoc", NM="_ZNK5clang15ConcreteTypeLoc15getInnerTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc15getInnerTypeLocEv")
  //</editor-fold>
  protected TypeLoc getInnerTypeLoc() /*const*/ {
    return new TypeLoc(asDerived().getInnerType(), getNonLocalData());
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getInnerTypeSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 421,
   FQN="clang::ConcreteTypeLoc::getInnerTypeSize", NM="_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeEv")
  //</editor-fold>
  private /*uint*/int getInnerTypeSize() /*const*/ {
    return getInnerTypeSize(asDerived().getInnerType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getInnerTypeSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 425,
   FQN="clang::ConcreteTypeLoc::getInnerTypeSize", NM="_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeENS0_14HasNoInnerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeENS0_14HasNoInnerTypeE")
  //</editor-fold>
  private /*uint*/int getInnerTypeSize(HasNoInnerType _) /*const*/ {
    return 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getInnerTypeSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 429,
   FQN="clang::ConcreteTypeLoc::getInnerTypeSize", NM="_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeENS_8QualTypeE")
  //</editor-fold>
  private /*uint*/int getInnerTypeSize(QualType _) /*const*/ {
    if (_ instanceof HasNoInnerType) {
      return getInnerTypeSize((HasNoInnerType)_);
    }
    return getInnerTypeLoc().getFullDataSize();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 433,
   FQN="clang::ConcreteTypeLoc::getNextTypeAlign", NM="_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignEv")
  //</editor-fold>
  private /*uint*/int getNextTypeAlign() /*const*/ {
    return getNextTypeAlign(asDerived().getInnerType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 437,
   FQN="clang::ConcreteTypeLoc::getNextTypeAlign", NM="_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignENS0_14HasNoInnerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignENS0_14HasNoInnerTypeE")
  //</editor-fold>
  private /*uint*/int getNextTypeAlign(HasNoInnerType _) /*const*/ {
    return 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeAlign">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 441,
   FQN="clang::ConcreteTypeLoc::getNextTypeAlign", NM="_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignENS_8QualTypeE")
  //</editor-fold>
  private /*uint*/int getNextTypeAlign(QualType T) /*const*/ {
    if (T instanceof HasNoInnerType) {
      return getNextTypeAlign((HasNoInnerType)T);
    }    
    return TypeLoc.getLocalAlignmentForType(new QualType(T));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 445,
   FQN="clang::ConcreteTypeLoc::getNextTypeLoc", NM="_ZNK5clang15ConcreteTypeLoc14getNextTypeLocENS0_14HasNoInnerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc14getNextTypeLocENS0_14HasNoInnerTypeE")
  //</editor-fold>
  private TypeLoc getNextTypeLoc(HasNoInnerType _) /*const*/ {
    return new TypeLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 449,
   FQN="clang::ConcreteTypeLoc::getNextTypeLoc", NM="_ZNK5clang15ConcreteTypeLoc14getNextTypeLocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc14getNextTypeLocENS_8QualTypeE")
  //</editor-fold>
  private TypeLoc getNextTypeLoc(QualType T) /*const*/ {
    if (T instanceof HasNoInnerType) {
      return getNextTypeLoc((HasNoInnerType)T);
    }     
    return new TypeLoc(T, getNonLocalData());
  }

  private int $sizeof_LocalData() {
    return 1;
  }

  private int $alignOf_LocalData() {
    return 1;
  }
  
  protected Class<? extends TypeClass> getTypeClass() {
    throw new UnsupportedOperationException("Why not overridden?" + this.getClass());
  }
  
  protected LocalData createJavaEmptyLocalTypeLocInfo() {
    throw new UnsupportedOperationException("Why not overridden?" + this.getClass());
  }
  
  protected /*uint*/int javaAllocateLocalData() /*const*/ {
    assert Data != null;
    // LocalData is in the head
    type$ptr<LocalData> localData$Ptr = getLocalData$Ptr();
    /*uint*/int Total = 1; // $sizeof_LocalData();
    LocalData TLInfo = createJavaEmptyLocalTypeLocInfo();
    assert TLInfo != null;
    assert NativeTrace.assertDefaultValue(TLInfo) : "must be cloneable, see TypeLoc.DATA_DEEP_COPY";
    assert localData$Ptr.$star() == null : this.getClass().getSimpleName() + " already initialized ? " + localData$Ptr.$star();
    localData$Ptr.$set(TLInfo);
    int Extra = asDerived().getExtraLocalDataSize();
    if (Extra > 0) {
//    /*uint*/int extraAlign = asDerived().getExtraLocalDataAlignment();
//    Total = $ulong2uint(llvm.alignTo($uint2ulong(Total), $uint2ulong(extraAlign)));
      type$ptr extraLocalData$Ptr = getExtraLocalData();
      assert localData$Ptr.isComparableTo(extraLocalData$Ptr);
      assert localData$Ptr.$index()+Total == extraLocalData$Ptr.$index() : this.getClass().getSimpleName() + " extra data must follow data";
      // must be inited only once
      if (NativeTrace.isDebugMode()) {
        for(int i = 0; i < Extra; i++) {
          assert extraLocalData$Ptr.$star() == null : this.getClass().getSimpleName() + " already initialized extraLocalData$Ptr[" + i + "] ? " + extraLocalData$Ptr.$star();
        }
      }
      initJavaExtraLocalData(extraLocalData$Ptr, Extra);
      if (NativeTrace.isDebugMode()) {
        for(int i = 0; i < Extra; i++) {
          Object extra = extraLocalData$Ptr.$star();
          // when keep pointers it could be null as well
          assert extra != null || extra == null: this.getClass().getSimpleName() + " not initialized extraLocalData$Ptr[" + i + "] ? " + extraLocalData$Ptr.$star();
        }
      }
      Total += Extra;
    }
    return Total;
  }
  
  protected void initJavaExtraLocalData(type$ptr extraLocalData$Ptr, int NumExtra) {
    assert NumExtra == 0 : "Why not overridden if has extra data in getExtraLocalDataSize?" + this.getClass();
  }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
