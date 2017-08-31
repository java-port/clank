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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.dwarf.Tag;


/// \brief Base class for variables.
//<editor-fold defaultstate="collapsed" desc="llvm::DIVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1812,
 FQN="llvm::DIVariable", NM="_ZN4llvm10DIVariableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DIVariableE")
//</editor-fold>
public class DIVariable extends /*public*/ DINode implements Destructors.ClassWithDestructor {
  private /*uint*/int Line;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::DIVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1816,
   FQN="llvm::DIVariable::DIVariable", NM="_ZN4llvm10DIVariableC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DIVariableC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeEjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  protected DIVariable(final LLVMContext /*&*/ C, /*uint*/int ID, Metadata.StorageType Storage, /*uint*/int Line,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DINode(C, ID, Storage, dwarf::DW_TAG_variable, Ops), Line(Line)
    //START JInit
    /*ExprWithCleanups*/super(C, ID, Storage, $ushort2uint(Tag.DW_TAG_variable), new ArrayRef<Metadata /*P*/ >(Ops));
    this.Line = Line;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::~DIVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1819,
   FQN="llvm::DIVariable::~DIVariable", NM="_ZN4llvm10DIVariableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DIVariableD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    super.$destroy();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1822,
   FQN="llvm::DIVariable::getLine", NM="_ZNK4llvm10DIVariable7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1823,
   FQN="llvm::DIVariable::getScope", NM="_ZNK4llvm10DIVariable8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable8getScopeEv")
  //</editor-fold>
  public DIScope /*P*/ getScope() /*const*/ {
    return cast_or_null_DIScope(getRawScope());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1824,
   FQN="llvm::DIVariable::getName", NM="_ZNK4llvm10DIVariable7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return getStringOperand(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1825,
   FQN="llvm::DIVariable::getFile", NM="_ZNK4llvm10DIVariable7getFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable7getFileEv")
  //</editor-fold>
  public DIFile /*P*/ getFile() /*const*/ {
    return cast_or_null_DIFile(getRawFile());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1826,
   FQN="llvm::DIVariable::getType", NM="_ZNK4llvm10DIVariable7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable7getTypeEv")
  //</editor-fold>
  public TypedDINodeRef<DIType> getType() /*const*/ {
    return new TypedDINodeRef<DIType>(DIType.class, getRawType());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1828,
   FQN="llvm::DIVariable::getFilename", NM="_ZNK4llvm10DIVariable11getFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable11getFilenameEv")
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

  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1833,
   FQN="llvm::DIVariable::getDirectory", NM="_ZNK4llvm10DIVariable12getDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable12getDirectoryEv")
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


  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getRawScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1839,
   FQN="llvm::DIVariable::getRawScope", NM="_ZNK4llvm10DIVariable11getRawScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable11getRawScopeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawScope() /*const*/ {
    return getOperand(0).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getRawName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1840,
   FQN="llvm::DIVariable::getRawName", NM="_ZNK4llvm10DIVariable10getRawNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable10getRawNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getRawFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1841,
   FQN="llvm::DIVariable::getRawFile", NM="_ZNK4llvm10DIVariable10getRawFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable10getRawFileEv")
  //</editor-fold>
  public Metadata /*P*/ getRawFile() /*const*/ {
    return getOperand(2).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::getRawType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1842,
   FQN="llvm::DIVariable::getRawType", NM="_ZNK4llvm10DIVariable10getRawTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DIVariable10getRawTypeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawType() /*const*/ {
    return getOperand(3).$Metadata$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIVariable::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1844,
   FQN="llvm::DIVariable::classof", NM="_ZN4llvm10DIVariable7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DIVariable7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DILocalVariableKind.getValue()
       || MD.getMetadataID() == MetadataKind.DIGlobalVariableKind.getValue();
  }


  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + super.toString(); // NOI18N
  }
}
