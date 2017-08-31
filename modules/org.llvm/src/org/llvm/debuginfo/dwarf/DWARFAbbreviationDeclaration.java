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

package org.llvm.debuginfo.dwarf;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 20,
 FQN="llvm::DWARFAbbreviationDeclaration", NM="_ZN4llvm28DWARFAbbreviationDeclarationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm28DWARFAbbreviationDeclarationE")
//</editor-fold>
public class DWARFAbbreviationDeclaration implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::AttributeSpec">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 22,
   FQN="llvm::DWARFAbbreviationDeclaration::AttributeSpec", NM="_ZN4llvm28DWARFAbbreviationDeclaration13AttributeSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm28DWARFAbbreviationDeclaration13AttributeSpecE")
  //</editor-fold>
  public static class/*struct*/ AttributeSpec {
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::AttributeSpec::AttributeSpec">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 23,
     FQN="llvm::DWARFAbbreviationDeclaration::AttributeSpec::AttributeSpec", NM="_ZN4llvm28DWARFAbbreviationDeclaration13AttributeSpecC1Ett",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm28DWARFAbbreviationDeclaration13AttributeSpecC1Ett")
    //</editor-fold>
    public AttributeSpec(/*uint16_t*/char Attr, /*uint16_t*/char Form) {
      // : Attr(Attr), Form(Form) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    public /*uint16_t*/char Attr;
    public /*uint16_t*/char Form;
    
    @Override public String toString() {
      return "" + "Attr=" + $ushort2uint(Attr) // NOI18N
                + ", Form=" + $ushort2uint(Form); // NOI18N
    }
  };
  // JAVA: typedef SmallVector<AttributeSpec, 8> AttributeSpecVector
//  public final class AttributeSpecVector extends SmallVector<AttributeSpec>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::DWARFAbbreviationDeclaration">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 29,
   FQN="llvm::DWARFAbbreviationDeclaration::DWARFAbbreviationDeclaration", NM="_ZN4llvm28DWARFAbbreviationDeclarationC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm28DWARFAbbreviationDeclarationC1Ev")
  //</editor-fold>
  public DWARFAbbreviationDeclaration() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::getCode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 31,
   FQN="llvm::DWARFAbbreviationDeclaration::getCode", NM="_ZNK4llvm28DWARFAbbreviationDeclaration7getCodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm28DWARFAbbreviationDeclaration7getCodeEv")
  //</editor-fold>
  public /*uint32_t*/int getCode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::getTag">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 32,
   FQN="llvm::DWARFAbbreviationDeclaration::getTag", NM="_ZNK4llvm28DWARFAbbreviationDeclaration6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm28DWARFAbbreviationDeclaration6getTagEv")
  //</editor-fold>
  public /*uint32_t*/int getTag() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::hasChildren">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 33,
   FQN="llvm::DWARFAbbreviationDeclaration::hasChildren", NM="_ZNK4llvm28DWARFAbbreviationDeclaration11hasChildrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm28DWARFAbbreviationDeclaration11hasChildrenEv")
  //</editor-fold>
  public boolean hasChildren() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // JAVA: typedef iterator_range<AttributeSpecVector::const_iterator> attr_iterator_range
//  public final class attr_iterator_range extends iterator_range</*const*/ AttributeSpec>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::attributes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 38,
   FQN="llvm::DWARFAbbreviationDeclaration::attributes", NM="_ZNK4llvm28DWARFAbbreviationDeclaration10attributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm28DWARFAbbreviationDeclaration10attributesEv")
  //</editor-fold>
  public iterator_range</*const*/ AttributeSpec> attributes() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::getFormByIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 42,
   FQN="llvm::DWARFAbbreviationDeclaration::getFormByIndex", NM="_ZNK4llvm28DWARFAbbreviationDeclaration14getFormByIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm28DWARFAbbreviationDeclaration14getFormByIndexEj")
  //</editor-fold>
  public /*uint16_t*/char getFormByIndex(/*uint32_t*/int idx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::findAttributeIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 46,
   FQN="llvm::DWARFAbbreviationDeclaration::findAttributeIndex", NM="_ZNK4llvm28DWARFAbbreviationDeclaration18findAttributeIndexEt",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm28DWARFAbbreviationDeclaration18findAttributeIndexEt")
  //</editor-fold>
  public /*uint32_t*/int findAttributeIndex(/*uint16_t*/char attr) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::extract">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 47,
   FQN="llvm::DWARFAbbreviationDeclaration::extract", NM="_ZN4llvm28DWARFAbbreviationDeclaration7extractENS_13DataExtractorEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm28DWARFAbbreviationDeclaration7extractENS_13DataExtractorEPj")
  //</editor-fold>
  public boolean extract(DataExtractor Data, /*uint32_t P*/uint$ptr OffsetPtr) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 48,
   FQN="llvm::DWARFAbbreviationDeclaration::dump", NM="_ZNK4llvm28DWARFAbbreviationDeclaration4dumpERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm28DWARFAbbreviationDeclaration4dumpERNS_11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::clear">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 51,
   FQN="llvm::DWARFAbbreviationDeclaration::clear", NM="_ZN4llvm28DWARFAbbreviationDeclaration5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm28DWARFAbbreviationDeclaration5clearEv")
  //</editor-fold>
  private void clear() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  private /*uint32_t*/int Code;
  private /*uint32_t*/int Tag;
  private boolean HasChildren;
  
  private SmallVector<AttributeSpec> AttributeSpecs;
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFAbbreviationDeclaration::~DWARFAbbreviationDeclaration">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFAbbreviationDeclaration.h", line = 20,
   FQN="llvm::DWARFAbbreviationDeclaration::~DWARFAbbreviationDeclaration", NM="_ZN4llvm28DWARFAbbreviationDeclarationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm28DWARFAbbreviationDeclarationD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Code=" + Code // NOI18N
              + ", Tag=" + Tag // NOI18N
              + ", HasChildren=" + HasChildren // NOI18N
              + ", AttributeSpecs=" + AttributeSpecs; // NOI18N
  }
}
