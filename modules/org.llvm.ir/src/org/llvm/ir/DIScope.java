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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief Base class for scope-like contexts.
///
/// Base class for lexical scopes and types (which are also declaration
/// contexts).
///
/// TODO: Separate the concepts of declaration contexts and lexical scopes.
//<editor-fold defaultstate="collapsed" desc="llvm::DIScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 399,
 FQN="llvm::DIScope", NM="_ZN4llvm7DIScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIScopeE")
//</editor-fold>
public class DIScope extends /*public*/ DINode implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIScope::DIScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 401,
   FQN="llvm::DIScope::DIScope", NM="_ZN4llvm7DIScopeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIScopeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  protected DIScope(final LLVMContext /*&*/ C, /*uint*/int ID, Metadata.StorageType Storage, /*uint*/int Tag,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DINode(C, ID, Storage, Tag, Ops)
    //START JInit
    /*ExprWithCleanups*/super(C, ID, Storage, Tag, new ArrayRef<Metadata /*P*/ >(Ops));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIScope::~DIScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 404,
   FQN="llvm::DIScope::~DIScope", NM="_ZN4llvm7DIScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIScopeD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    super.$destroy();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIScope::getFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 407,
   FQN="llvm::DIScope::getFile", NM="_ZNK4llvm7DIScope7getFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIScope7getFileEv")
  //</editor-fold>
  public DIFile /*P*/ getFile() /*const*/ {
    return cast_or_null_DIFile(getRawFile());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIScope::getFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 492,
   FQN="llvm::DIScope::getFilename", NM="_ZNK4llvm7DIScope11getFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIScope11getFilenameEv")
  //</editor-fold>
  public StringRef getFilename() /*const*/ {
    {
      DIFile /*P*/ F = getFile();
      if ((F != null)) {
        return F.getFilename();
      }
    }
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIScope::getDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 498,
   FQN="llvm::DIScope::getDirectory", NM="_ZNK4llvm7DIScope12getDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIScope12getDirectoryEv")
  //</editor-fold>
  public StringRef getDirectory() /*const*/ {
    {
      DIFile /*P*/ F = getFile();
      if ((F != null)) {
        return F.getDirectory();
      }
    }
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIScope::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 140,
   FQN="llvm::DIScope::getName", NM="_ZNK4llvm7DIScope7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIScope7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    {
      /*const*/ DIType /*P*/ T = dyn_cast_DIType(this);
      if ((T != null)) {
        return T.getName();
      }
    }
    {
      /*const*/ DISubprogram /*P*/ SP = dyn_cast_DISubprogram(this);
      if ((SP != null)) {
        return SP.getName();
      }
    }
    {
      /*const*/ DINamespace /*P*/ NS = dyn_cast_DINamespace(this);
      if ((NS != null)) {
        return NS.getName();
      }
    }
    {
      /*const*/ DIModule /*P*/ M = dyn_cast_DIModule(this);
      if ((M != null)) {
        return M.getName();
      }
    }
    assert ((isa_DILexicalBlockBase(this) || isa_DIFile(this) || isa_DICompileUnit(this))) : "Unhandled type of scope.";
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIScope::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 119,
   FQN="llvm::DIScope::getScope", NM="_ZNK4llvm7DIScope8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIScope8getScopeEv")
  //</editor-fold>
  public TypedDINodeRef<DIScope> getScope$Ref() /*const*/ {
    {
      /*const*/ DIType /*P*/ T = dyn_cast_DIType(this);
      if ((T != null)) {
        return T.getScope();
      }
    }
    {

      /*const*/ DISubprogram /*P*/ SP = dyn_cast_DISubprogram(this);
      if ((SP != null)) {
        return SP.getScope();
      }
    }
    {

      /*const*/ DILexicalBlockBase /*P*/ LB = dyn_cast_DILexicalBlockBase(this);
      if ((LB != null)) {
        return new TypedDINodeRef<DIScope>(DIScope.class, LB.getScope());
      }
    }
    {

      /*const*/ DINamespace /*P*/ NS = dyn_cast_DINamespace(this);
      if ((NS != null)) {
        return new TypedDINodeRef<DIScope>(DIScope.class, NS.getScope());
      }
    }
    {

      /*const*/ DIModule /*P*/ M = dyn_cast_DIModule(this);
      if ((M != null)) {
        return new TypedDINodeRef<DIScope>(DIScope.class, M.getScope());
      }
    }
    assert ((isa_DIFile(this) || isa_DICompileUnit(this))) : "Unhandled type of scope.";
    return new TypedDINodeRef<DIScope>(DIScope.class, JD$NullPtr.INSTANCE, null);
  }


  /// \brief Return the raw underlying file.
  ///
  /// An \a DIFile is an \a DIScope, but it doesn't point at a separate file
  /// (it\em is the file).  If \c this is an \a DIFile, we need to return \c
  /// this.  Otherwise, return the first operand, which is where all other
  /// subclasses store their file pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::DIScope::getRawFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 421,
   FQN="llvm::DIScope::getRawFile", NM="_ZNK4llvm7DIScope10getRawFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIScope10getRawFileEv")
  //</editor-fold>
  public Metadata /*P*/ getRawFile() /*const*/ {
    return isa_DIFile(this) ? ((/*const_cast*/DIScope /*P*/ )(this)) : ((/*static_cast*/Metadata /*P*/ )(getOperand(0).$Metadata$P()));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIScope::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 426,
   FQN="llvm::DIScope::classof", NM="_ZN4llvm7DIScope7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIScope7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    switch (Metadata.MetadataKind.valueOf(MD.getMetadataID())) {
     default:
      return false;
     case DIBasicTypeKind:
     case DIDerivedTypeKind:
     case DICompositeTypeKind:
     case DISubroutineTypeKind:
     case DIFileKind:
     case DICompileUnitKind:
     case DISubprogramKind:
     case DILexicalBlockKind:
     case DILexicalBlockFileKind:
     case DINamespaceKind:
     case DIModuleKind:
      return true;
    }
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
