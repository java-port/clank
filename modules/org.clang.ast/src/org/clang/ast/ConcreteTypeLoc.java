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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;


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
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*specializations Concrete$... must be used instead*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 331,
 FQN="clang::ConcreteTypeLoc", NM="_ZN5clang15ConcreteTypeLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15ConcreteTypeLocE")
//</editor-fold>
public class ConcreteTypeLoc</*class Base, *//*class*/ Derived extends ConcreteTypeLoc, /*class*/ TypeClass extends Type, /*class*/ LocalData>  /*extends own template param public Base*/ {
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected ConcreteTypeLoc() {
    throw new UnsupportedOperationException("replacemethod for super() called in derived class");
  }
  protected ConcreteTypeLoc(Derived $Prm0) {
    throw new UnsupportedOperationException("replacemethod for super-copy() called in derived class");
  }
  protected ConcreteTypeLoc(JD$Move _dparam, Derived $Prm0) {
    throw new UnsupportedOperationException("replacemethod for super-move() called in derived class");
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::asDerived">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 334,
   FQN="clang::ConcreteTypeLoc::asDerived", NM="_ZNK5clang15ConcreteTypeLoc9asDerivedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc9asDerivedEv")
  //</editor-fold>
  private /*const*/ Derived /*P*/ asDerived() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  /*friend  class TypeLoc*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::isKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 339,
   FQN="clang::ConcreteTypeLoc::isKind", NM="_ZN5clang15ConcreteTypeLoc6isKindERKNS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15ConcreteTypeLoc6isKindERKNS_7TypeLocE")
  //</editor-fold>
  /*friend*//*private*/ static boolean isKind(/*const*/ TypeLoc /*&*/ TL) {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::classofType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 344,
   FQN="clang::ConcreteTypeLoc::classofType", NM="_ZN5clang15ConcreteTypeLoc11classofTypeEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15ConcreteTypeLoc11classofTypeEPKNS_4TypeE")
  //</editor-fold>
  /*friend*//*private*/ static boolean classofType(/*const*/ Type /*P*/ Ty) {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getLocalDataAlignment">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 349,
   FQN="clang::ConcreteTypeLoc::getLocalDataAlignment", NM="_ZNK5clang15ConcreteTypeLoc21getLocalDataAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc21getLocalDataAlignmentEv")
  //</editor-fold>
  public /*uint*/int getLocalDataAlignment() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getLocalDataSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 353,
   FQN="clang::ConcreteTypeLoc::getLocalDataSize", NM="_ZNK5clang15ConcreteTypeLoc16getLocalDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getLocalDataSizeEv")
  //</editor-fold>
  public /*uint*/int getLocalDataSize() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::copyLocal">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 361,
   FQN="clang::ConcreteTypeLoc::copyLocal", NM="_ZN5clang15ConcreteTypeLoc9copyLocalET0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15ConcreteTypeLoc9copyLocalET0_")
  //</editor-fold>
  public void copyLocal(Derived other) {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 375,
   FQN="clang::ConcreteTypeLoc::getNextTypeLoc", NM="_ZNK5clang15ConcreteTypeLoc14getNextTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc14getNextTypeLocEv")
  //</editor-fold>
  public TypeLoc getNextTypeLoc() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getTypePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 379,
   FQN="clang::ConcreteTypeLoc::getTypePtr", NM="_ZNK5clang15ConcreteTypeLoc10getTypePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc10getTypePtrEv")
  //</editor-fold>
  public /*const*/ TypeClass /*P*/ getTypePtr() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getExtraLocalDataSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 384,
   FQN="clang::ConcreteTypeLoc::getExtraLocalDataSize", NM="_ZNK5clang15ConcreteTypeLoc21getExtraLocalDataSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc21getExtraLocalDataSizeEv")
  //</editor-fold>
  protected /*uint*/int getExtraLocalDataSize() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getExtraLocalDataAlignment">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 388,
   FQN="clang::ConcreteTypeLoc::getExtraLocalDataAlignment", NM="_ZNK5clang15ConcreteTypeLoc26getExtraLocalDataAlignmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc26getExtraLocalDataAlignmentEv")
  //</editor-fold>
  protected /*uint*/int getExtraLocalDataAlignment() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getLocalData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 392,
   FQN="clang::ConcreteTypeLoc::getLocalData", NM="_ZNK5clang15ConcreteTypeLoc12getLocalDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc12getLocalDataEv")
  //</editor-fold>
  protected LocalData /*P*/ getLocalData() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
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
  protected Object/*void P*/ getExtraLocalData() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNonLocalData">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 406,
   FQN="clang::ConcreteTypeLoc::getNonLocalData", NM="_ZNK5clang15ConcreteTypeLoc15getNonLocalDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc15getNonLocalDataEv")
  //</editor-fold>
  protected Object/*void P*/ getNonLocalData() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::HasNoInnerType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*HasNoInnerType extends QualType*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 413,
   FQN="clang::ConcreteTypeLoc::HasNoInnerType", NM="_ZN5clang15ConcreteTypeLoc14HasNoInnerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZN5clang15ConcreteTypeLoc14HasNoInnerTypeE")
  //</editor-fold>
  protected static class/*struct*/ HasNoInnerType extends QualType {
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
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getInnerTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 416,
   FQN="clang::ConcreteTypeLoc::getInnerTypeLoc", NM="_ZNK5clang15ConcreteTypeLoc15getInnerTypeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc15getInnerTypeLocEv")
  //</editor-fold>
  protected TypeLoc getInnerTypeLoc() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getInnerTypeSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 421,
   FQN="clang::ConcreteTypeLoc::getInnerTypeSize", NM="_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeEv")
  //</editor-fold>
  private /*uint*/int getInnerTypeSize() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getInnerTypeSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 425,
   FQN="clang::ConcreteTypeLoc::getInnerTypeSize", NM="_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeENS0_14HasNoInnerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeENS0_14HasNoInnerTypeE")
  //</editor-fold>
  private /*uint*/int getInnerTypeSize(HasNoInnerType _) /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getInnerTypeSize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 429,
   FQN="clang::ConcreteTypeLoc::getInnerTypeSize", NM="_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getInnerTypeSizeENS_8QualTypeE")
  //</editor-fold>
  private /*uint*/int getInnerTypeSize(QualType _) /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeAlign">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 433,
   FQN="clang::ConcreteTypeLoc::getNextTypeAlign", NM="_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignEv")
  //</editor-fold>
  private /*uint*/int getNextTypeAlign() /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeAlign">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 437,
   FQN="clang::ConcreteTypeLoc::getNextTypeAlign", NM="_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignENS0_14HasNoInnerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignENS0_14HasNoInnerTypeE")
  //</editor-fold>
  private /*uint*/int getNextTypeAlign(HasNoInnerType _) /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeAlign">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 441,
   FQN="clang::ConcreteTypeLoc::getNextTypeAlign", NM="_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc16getNextTypeAlignENS_8QualTypeE")
  //</editor-fold>
  private /*uint*/int getNextTypeAlign(QualType T) /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 445,
   FQN="clang::ConcreteTypeLoc::getNextTypeLoc", NM="_ZNK5clang15ConcreteTypeLoc14getNextTypeLocENS0_14HasNoInnerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc14getNextTypeLocENS0_14HasNoInnerTypeE")
  //</editor-fold>
  private TypeLoc getNextTypeLoc(HasNoInnerType _) /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ConcreteTypeLoc::getNextTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TypeLoc.h", line = 449,
   FQN="clang::ConcreteTypeLoc::getNextTypeLoc", NM="_ZNK5clang15ConcreteTypeLoc14getNextTypeLocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypeLoc.cpp -nm=_ZNK5clang15ConcreteTypeLoc14getNextTypeLocENS_8QualTypeE")
  //</editor-fold>
  private TypeLoc getNextTypeLoc(QualType T) /*const*/ {
    throw new UnsupportedOperationException("Specializaton Class Must Be Used");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
