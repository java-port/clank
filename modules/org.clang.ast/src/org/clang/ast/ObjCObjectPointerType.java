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
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// Represents a pointer to an Objective C object.
///
/// These are constructed from pointer declarators when the pointee type is
/// an ObjCObjectType (or sugar for one).  In addition, the 'id' and 'Class'
/// types are typedefs for these, and the protocol-qualified types 'id<P>'
/// and 'Class<P>' are translated into these.
///
/// Pointers to pointers to Objective C objects are still PointerTypes;
/// only the first level of pointer gets it own type implementation.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4991,
 FQN="clang::ObjCObjectPointerType", NM="_ZN5clang21ObjCObjectPointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang21ObjCObjectPointerTypeE")
//</editor-fold>
public class ObjCObjectPointerType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  private QualType PointeeType;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::ObjCObjectPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4994,
   FQN="clang::ObjCObjectPointerType::ObjCObjectPointerType", NM="_ZN5clang21ObjCObjectPointerTypeC1ENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang21ObjCObjectPointerTypeC1ENS_8QualTypeES1_")
  //</editor-fold>
  /*friend*/public/*private*/ ObjCObjectPointerType(QualType Canonical, QualType Pointee) {
    // : Type(ObjCObjectPointer, Canonical, Pointee->isDependentType(), Pointee->isInstantiationDependentType(), Pointee->isVariablyModifiedType(), Pointee->containsUnexpandedParameterPack()), FoldingSetNode(), PointeeType(Pointee) 
    //START JInit
    super(TypeClass.ObjCObjectPointer, new QualType(Canonical), 
        Pointee.$arrow().isDependentType(), 
        Pointee.$arrow().isInstantiationDependentType(), 
        Pointee.$arrow().isVariablyModifiedType(), 
        Pointee.$arrow().containsUnexpandedParameterPack());
    $Node();
    this.PointeeType = new QualType(Pointee);
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  /// Gets the type pointed to by this ObjC pointer.
  /// The result will always be an ObjCObjectType or sugar thereof.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::getPointeeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5006,
   FQN="clang::ObjCObjectPointerType::getPointeeType", NM="_ZNK5clang21ObjCObjectPointerType14getPointeeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType14getPointeeTypeEv")
  //</editor-fold>
  public QualType getPointeeType() /*const*/ {
    return new QualType(PointeeType);
  }

  
  /// Gets the type pointed to by this ObjC pointer.  Always returns non-null.
  ///
  /// This method is equivalent to getPointeeType() except that
  /// it discards any typedefs (or other sugar) between this
  /// type and the "outermost" object type.  So for:
  /// \code
  ///   \@class A; \@protocol P; \@protocol Q;
  ///   typedef A<P> AP;
  ///   typedef A A1;
  ///   typedef A1<P> A1P;
  ///   typedef A1P<Q> A1PQ;
  /// \endcode
  /// For 'A*', getObjectType() will return 'A'.
  /// For 'A<P>*', getObjectType() will return 'A<P>'.
  /// For 'AP*', getObjectType() will return 'A<P>'.
  /// For 'A1*', getObjectType() will return 'A'.
  /// For 'A1<P>*', getObjectType() will return 'A1<P>'.
  /// For 'A1P*', getObjectType() will return 'A1<P>'.
  /// For 'A1PQ*', getObjectType() will return 'A1<Q>', because
  ///   adding protocols to a protocol-qualified base discards the
  ///   old qualifiers (for now).  But if it didn't, getObjectType()
  ///   would return 'A1P<Q>' (and we'd have to make iterating over
  ///   qualifiers more complicated).
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::getObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5031,
   FQN="clang::ObjCObjectPointerType::getObjectType", NM="_ZNK5clang21ObjCObjectPointerType13getObjectTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType13getObjectTypeEv")
  //</editor-fold>
  public /*const*/ ObjCObjectType /*P*/ getObjectType() /*const*/ {
    return PointeeType.$arrow().castAs(ObjCObjectType.class);
  }

  
  /// If this pointer points to an Objective C
  /// \@interface type, gets the type for that interface.  Any protocol
  /// qualifiers on the interface are ignored.
  ///
  /// \return null if the base type for this pointer is 'id' or 'Class'
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::getInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1446,
   FQN="clang::ObjCObjectPointerType::getInterfaceType", NM="_ZNK5clang21ObjCObjectPointerType16getInterfaceTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType16getInterfaceTypeEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceType /*P*/ getInterfaceType() /*const*/ {
    {
      ObjCInterfaceDecl /*P*/ interfaceDecl = getObjectType().getInterface();
      if ((interfaceDecl != null)) {
        return interfaceDecl.getASTContext().getObjCInterfaceType(interfaceDecl).$arrow().
            castAs$ObjCInterfaceType();
      }
    }
    
    return null;
  }

  
  /// If this pointer points to an Objective \@interface
  /// type, gets the declaration for that interface.
  ///
  /// \return null if the base type for this pointer is 'id' or 'Class'
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::getInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5046,
   FQN="clang::ObjCObjectPointerType::getInterfaceDecl", NM="_ZNK5clang21ObjCObjectPointerType16getInterfaceDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType16getInterfaceDeclEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getInterfaceDecl() /*const*/ {
    return getObjectType().getInterface();
  }

  
  /// True if this is equivalent to the 'id' type, i.e. if
  /// its object type is the primitive 'id' type with no protocols.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isObjCIdType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5052,
   FQN="clang::ObjCObjectPointerType::isObjCIdType", NM="_ZNK5clang21ObjCObjectPointerType12isObjCIdTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType12isObjCIdTypeEv")
  //</editor-fold>
  public boolean isObjCIdType() /*const*/ {
    return getObjectType().isObjCUnqualifiedId();
  }

  
  /// True if this is equivalent to the 'Class' type,
  /// i.e. if its object tive is the primitive 'Class' type with no protocols.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isObjCClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5058,
   FQN="clang::ObjCObjectPointerType::isObjCClassType", NM="_ZNK5clang21ObjCObjectPointerType15isObjCClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType15isObjCClassTypeEv")
  //</editor-fold>
  public boolean isObjCClassType() /*const*/ {
    return getObjectType().isObjCUnqualifiedClass();
  }

  
  /// True if this is equivalent to the 'id' or 'Class' type,
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isObjCIdOrClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5063,
   FQN="clang::ObjCObjectPointerType::isObjCIdOrClassType", NM="_ZNK5clang21ObjCObjectPointerType19isObjCIdOrClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType19isObjCIdOrClassTypeEv")
  //</editor-fold>
  public boolean isObjCIdOrClassType() /*const*/ {
    return getObjectType().isObjCUnqualifiedIdOrClass();
  }

  
  /// True if this is equivalent to 'id<P>' for some non-empty set of
  /// protocols.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isObjCQualifiedIdType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5069,
   FQN="clang::ObjCObjectPointerType::isObjCQualifiedIdType", NM="_ZNK5clang21ObjCObjectPointerType21isObjCQualifiedIdTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType21isObjCQualifiedIdTypeEv")
  //</editor-fold>
  public boolean isObjCQualifiedIdType() /*const*/ {
    return getObjectType().isObjCQualifiedId();
  }

  
  /// True if this is equivalent to 'Class<P>' for some non-empty set of
  /// protocols.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isObjCQualifiedClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5075,
   FQN="clang::ObjCObjectPointerType::isObjCQualifiedClassType", NM="_ZNK5clang21ObjCObjectPointerType24isObjCQualifiedClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType24isObjCQualifiedClassTypeEv")
  //</editor-fold>
  public boolean isObjCQualifiedClassType() /*const*/ {
    return getObjectType().isObjCQualifiedClass();
  }

  
  /// Whether this is a "__kindof" type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isKindOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5080,
   FQN="clang::ObjCObjectPointerType::isKindOfType", NM="_ZNK5clang21ObjCObjectPointerType12isKindOfTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType12isKindOfTypeEv")
  //</editor-fold>
  public boolean isKindOfType() /*const*/ {
    return getObjectType().isKindOfType();
  }

  
  /// Whether this type is specialized, meaning that it has type arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isSpecialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5083,
   FQN="clang::ObjCObjectPointerType::isSpecialized", NM="_ZNK5clang21ObjCObjectPointerType13isSpecializedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType13isSpecializedEv")
  //</editor-fold>
  public boolean isSpecialized() /*const*/ {
    return getObjectType().isSpecialized();
  }

  
  /// Whether this type is specialized, meaning that it has type arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isSpecializedAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5086,
   FQN="clang::ObjCObjectPointerType::isSpecializedAsWritten", NM="_ZNK5clang21ObjCObjectPointerType22isSpecializedAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType22isSpecializedAsWrittenEv")
  //</editor-fold>
  public boolean isSpecializedAsWritten() /*const*/ {
    return getObjectType().isSpecializedAsWritten();
  }

  
  /// Whether this type is unspecialized, meaning that is has no type arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isUnspecialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5091,
   FQN="clang::ObjCObjectPointerType::isUnspecialized", NM="_ZNK5clang21ObjCObjectPointerType15isUnspecializedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType15isUnspecializedEv")
  //</editor-fold>
  public boolean isUnspecialized() /*const*/ {
    return getObjectType().isUnspecialized();
  }

  
  /// Determine whether this object type is "unspecialized" as
  /// written, meaning that it has no type arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isUnspecializedAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5095,
   FQN="clang::ObjCObjectPointerType::isUnspecializedAsWritten", NM="_ZNK5clang21ObjCObjectPointerType24isUnspecializedAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType24isUnspecializedAsWrittenEv")
  //</editor-fold>
  public boolean isUnspecializedAsWritten() /*const*/ {
    return !isSpecializedAsWritten();
  }

  
  /// Retrieve the type arguments for this type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::getTypeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5098,
   FQN="clang::ObjCObjectPointerType::getTypeArgs", NM="_ZNK5clang21ObjCObjectPointerType11getTypeArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType11getTypeArgsEv")
  //</editor-fold>
  public ArrayRef<QualType> getTypeArgs() /*const*/ {
    return getObjectType().getTypeArgs();
  }

  
  /// Retrieve the type arguments for this type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::getTypeArgsAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5103,
   FQN="clang::ObjCObjectPointerType::getTypeArgsAsWritten", NM="_ZNK5clang21ObjCObjectPointerType20getTypeArgsAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType20getTypeArgsAsWrittenEv")
  //</editor-fold>
  public ArrayRef<QualType> getTypeArgsAsWritten() /*const*/ {
    return getObjectType().getTypeArgsAsWritten();
  }

  
  /// An iterator over the qualifiers on the object type.  Provided
  /// for convenience.  This will always iterate over the full set of
  /// protocols on a type, not just those provided directly.
  /*typedef ObjCObjectType::qual_iterator qual_iterator*/
//  public final class qual_iterator extends type$ptr<ObjCProtocolDecl/*P*/>/*qual_iterator*/{ };
  /*typedef llvm::iterator_range<qual_iterator> qual_range*/
//  public final class qual_range extends iterator_range<ObjCProtocolDecl /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::quals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5113,
   FQN="clang::ObjCObjectPointerType::quals", NM="_ZNK5clang21ObjCObjectPointerType5qualsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType5qualsEv")
  //</editor-fold>
  public iterator_range<ObjCProtocolDecl /*P*/ /*const*/> quals() /*const*/ {
    return new iterator_range<ObjCProtocolDecl /*P*/ /*const*/>(qual_begin(), qual_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::qual_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5114,
   FQN="clang::ObjCObjectPointerType::qual_begin", NM="_ZNK5clang21ObjCObjectPointerType10qual_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType10qual_beginEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl/*P*/>/*qual_iterator*/ qual_begin() /*const*/ {
    return getObjectType().qual_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::qual_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5117,
   FQN="clang::ObjCObjectPointerType::qual_end", NM="_ZNK5clang21ObjCObjectPointerType8qual_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType8qual_endEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl/*P*/>/*qual_iterator*/ qual_end() /*const*/ {
    return getObjectType().qual_end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::qual_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5120,
   FQN="clang::ObjCObjectPointerType::qual_empty", NM="_ZNK5clang21ObjCObjectPointerType10qual_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType10qual_emptyEv")
  //</editor-fold>
  public boolean qual_empty() /*const*/ {
    return getObjectType().qual_empty();
  }

  
  /// Return the number of qualifying protocols on the object type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::getNumProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5123,
   FQN="clang::ObjCObjectPointerType::getNumProtocols", NM="_ZNK5clang21ObjCObjectPointerType15getNumProtocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType15getNumProtocolsEv")
  //</editor-fold>
  public /*uint*/int getNumProtocols() /*const*/ {
    return getObjectType().getNumProtocols();
  }

  
  /// Retrieve a qualifying protocol by index on the object type.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::getProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5128,
   FQN="clang::ObjCObjectPointerType::getProtocol", NM="_ZNK5clang21ObjCObjectPointerType11getProtocolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType11getProtocolEj")
  //</editor-fold>
  public ObjCProtocolDecl /*P*/ getProtocol(/*uint*/int I) /*const*/ {
    return getObjectType().getProtocol(I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5132,
   FQN="clang::ObjCObjectPointerType::isSugared", NM="_ZNK5clang21ObjCObjectPointerType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5133,
   FQN="clang::ObjCObjectPointerType::desugar", NM="_ZNK5clang21ObjCObjectPointerType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  /// Retrieve the type of the superclass of this object pointer type.
  ///
  /// This operation substitutes any type arguments into the
  /// superclass of the current class type, potentially producing a
  /// pointer to a specialization of the superclass type. Produces a
  /// null type if there is no superclass.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::getSuperClassType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1455,
   FQN="clang::ObjCObjectPointerType::getSuperClassType", NM="_ZNK5clang21ObjCObjectPointerType17getSuperClassTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType17getSuperClassTypeEv")
  //</editor-fold>
  public QualType getSuperClassType() /*const*/ {
    QualType superObjectType = getObjectType().getSuperClassType();
    if (superObjectType.isNull()) {
      return superObjectType;
    }
    
    final ASTContext /*&*/ ctx = getInterfaceDecl().getASTContext();
    return ctx.getObjCObjectPointerType(new QualType(superObjectType));
  }

  
  /// Strip off the Objective-C "kindof" type and (with it) any
  /// protocol qualifiers.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::stripObjCKindOfTypeAndQuals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 644,
   FQN="clang::ObjCObjectPointerType::stripObjCKindOfTypeAndQuals", NM="_ZNK5clang21ObjCObjectPointerType27stripObjCKindOfTypeAndQualsERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang21ObjCObjectPointerType27stripObjCKindOfTypeAndQualsERKNS_10ASTContextE")
  //</editor-fold>
  public /*const*/ ObjCObjectPointerType /*P*/ stripObjCKindOfTypeAndQuals(final /*const*/ ASTContext /*&*/ ctx) /*const*/ {
    if (!isKindOfType() && qual_empty()) {
      return this;
    }
    
    QualType obj = getObjectType().stripObjCKindOfTypeAndQuals(ctx);
    return ctx.getObjCObjectPointerType(new QualType(obj)).$arrow().castAs(ObjCObjectPointerType.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5148,
   FQN="clang::ObjCObjectPointerType::Profile", NM="_ZN5clang21ObjCObjectPointerType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang21ObjCObjectPointerType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5151,
   FQN="clang::ObjCObjectPointerType::Profile", NM="_ZN5clang21ObjCObjectPointerType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang21ObjCObjectPointerType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType T) {
    ID.AddPointer(T.getAsOpaquePtr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCObjectPointerType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5154,
   FQN="clang::ObjCObjectPointerType::classof", NM="_ZN5clang21ObjCObjectPointerType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang21ObjCObjectPointerType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.ObjCObjectPointer;
  }

  @Override public String toString() {
    return "" + "PointeeType=" + PointeeType // NOI18N
              + super.toString(); // NOI18N
  }
}
