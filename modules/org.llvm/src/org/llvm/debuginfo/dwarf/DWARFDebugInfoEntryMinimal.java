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
import org.llvm.support.Error;
import org.llvm.object.*;
import org.llvm.llvmc.*;
import org.llvm.java.LlvmFunctionPointers.*;
import org.llvm.java.LlvmJavaDifferentiators.*;
import org.llvm.debuginfo.*;
import org.llvm.llvmc.java.LlvmCFunctionPointers.*;
import org.llvm.mc.*;
import org.llvm.support.sys.*;
import org.llvm.ir.*;
import org.llvm.ir.java.IRFunctionPointers.*;
import org.llvm.support.dwarf.*;


/// DWARFDebugInfoEntryMinimal - A DIE with only the minimum required data.
//<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 29,
 FQN="llvm::DWARFDebugInfoEntryMinimal", NM="_ZN4llvm26DWARFDebugInfoEntryMinimalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm26DWARFDebugInfoEntryMinimalE")
//</editor-fold>
public class DWARFDebugInfoEntryMinimal {
  /// Offset within the .debug_info of the start of this entry.
  private /*uint32_t*/int Offset;
  
  /// How many to add to "this" to get the sibling.
  private /*uint32_t*/int SiblingIdx;
  
  private /*const*/ DWARFAbbreviationDeclaration /*P*/ AbbrevDecl;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::DWARFDebugInfoEntryMinimal">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 38,
   FQN="llvm::DWARFDebugInfoEntryMinimal::DWARFDebugInfoEntryMinimal", NM="_ZN4llvm26DWARFDebugInfoEntryMinimalC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm26DWARFDebugInfoEntryMinimalC1Ev")
  //</editor-fold>
  public DWARFDebugInfoEntryMinimal() {
    // : Offset(0), SiblingIdx(0), AbbrevDecl(null) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 41,
   FQN="llvm::DWARFDebugInfoEntryMinimal::dump", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal4dumpERNS_11raw_ostreamEPNS_9DWARFUnitEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal4dumpERNS_11raw_ostreamEPNS_9DWARFUnitEjj")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS, DWARFUnit /*P*/ u, /*uint*/int recurseDepth) /*const*/ {
    dump(OS, u, recurseDepth, 
      0);
  }
  public void dump(final raw_ostream /*&*/ OS, DWARFUnit /*P*/ u, /*uint*/int recurseDepth, 
      /*uint*/int indent/*= 0*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::dumpAttribute">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 43,
   FQN="llvm::DWARFDebugInfoEntryMinimal::dumpAttribute", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal13dumpAttributeERNS_11raw_ostreamEPNS_9DWARFUnitEPjttj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal13dumpAttributeERNS_11raw_ostreamEPNS_9DWARFUnitEPjttj")
  //</editor-fold>
  public void dumpAttribute(final raw_ostream /*&*/ OS, DWARFUnit /*P*/ u, /*uint32_t P*/uint$ptr offset_ptr, 
               /*uint16_t*/char attr, /*uint16_t*/char form) /*const*/ {
    dumpAttribute(OS, u, offset_ptr, 
               attr, form, 0);
  }
  public void dumpAttribute(final raw_ostream /*&*/ OS, DWARFUnit /*P*/ u, /*uint32_t P*/uint$ptr offset_ptr, 
               /*uint16_t*/char attr, /*uint16_t*/char form, /*uint*/int indent/*= 0*/) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Extracts a debug info entry, which is a child of a given unit,
  /// starting at a given offset. If DIE can't be extracted, returns false and
  /// doesn't change OffsetPtr.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::extractFast">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 49,
   FQN="llvm::DWARFDebugInfoEntryMinimal::extractFast", NM="_ZN4llvm26DWARFDebugInfoEntryMinimal11extractFastEPKNS_9DWARFUnitEPj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm26DWARFDebugInfoEntryMinimal11extractFastEPKNS_9DWARFUnitEPj")
  //</editor-fold>
  public boolean extractFast(/*const*/ DWARFUnit /*P*/ U, /*uint32_t P*/uint$ptr OffsetPtr) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getTag">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 51,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getTag", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal6getTagEv")
  //</editor-fold>
  public /*uint32_t*/int getTag() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::isNULL">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 52,
   FQN="llvm::DWARFDebugInfoEntryMinimal::isNULL", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal6isNULLEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal6isNULLEv")
  //</editor-fold>
  public boolean isNULL() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns true if DIE represents a subprogram (not inlined).
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::isSubprogramDIE">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 55,
   FQN="llvm::DWARFDebugInfoEntryMinimal::isSubprogramDIE", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal15isSubprogramDIEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal15isSubprogramDIEEv")
  //</editor-fold>
  public boolean isSubprogramDIE() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /// Returns true if DIE represents a subprogram or an inlined
  /// subroutine.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::isSubroutineDIE">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 58,
   FQN="llvm::DWARFDebugInfoEntryMinimal::isSubroutineDIE", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal15isSubroutineDIEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal15isSubroutineDIEEv")
  //</editor-fold>
  public boolean isSubroutineDIE() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 60,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getOffset", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal9getOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int getOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::hasChildren">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 61,
   FQN="llvm::DWARFDebugInfoEntryMinimal::hasChildren", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal11hasChildrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal11hasChildrenEv")
  //</editor-fold>
  public boolean hasChildren() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // We know we are kept in a vector of contiguous entries, so we know
  // our sibling will be some index after "this".
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getSibling">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 65,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getSibling", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal10getSiblingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal10getSiblingEv")
  //</editor-fold>
  public /*const*/ DWARFDebugInfoEntryMinimal /*P*/ getSibling() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // We know we are kept in a vector of contiguous entries, so we know
  // we don't need to store our child pointer, if we have a child it will
  // be the next entry in the list...
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getFirstChild">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 72,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getFirstChild", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal13getFirstChildEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal13getFirstChildEv")
  //</editor-fold>
  public /*const*/ DWARFDebugInfoEntryMinimal /*P*/ getFirstChild() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::setSibling">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 76,
   FQN="llvm::DWARFDebugInfoEntryMinimal::setSibling", NM="_ZN4llvm26DWARFDebugInfoEntryMinimal10setSiblingEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm26DWARFDebugInfoEntryMinimal10setSiblingEPKS0_")
  //</editor-fold>
  public void setSibling(/*const*/ DWARFDebugInfoEntryMinimal /*P*/ Sibling) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getAbbreviationDeclarationPtr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 85,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getAbbreviationDeclarationPtr", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal29getAbbreviationDeclarationPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal29getAbbreviationDeclarationPtrEv")
  //</editor-fold>
  public /*const*/ DWARFAbbreviationDeclaration /*P*/ getAbbreviationDeclarationPtr() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getAttributeValue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 89,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getAttributeValue", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal17getAttributeValueEPKNS_9DWARFUnitEtRNS_14DWARFFormValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal17getAttributeValueEPKNS_9DWARFUnitEtRNS_14DWARFFormValueE")
  //</editor-fold>
  public boolean getAttributeValue(/*const*/ DWARFUnit /*P*/ U, /*const*//*uint16_t*/char Attr, 
                   final DWARFFormValue /*&*/ FormValue) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getAttributeValueAsString">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 92,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getAttributeValueAsString", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal25getAttributeValueAsStringEPKNS_9DWARFUnitEtPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal25getAttributeValueAsStringEPKNS_9DWARFUnitEtPKc")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getAttributeValueAsString(/*const*/ DWARFUnit /*P*/ U, /*const*//*uint16_t*/char Attr, 
                           /*const*/char$ptr/*char P*/ FailValue) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getAttributeValueAsAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 95,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getAttributeValueAsAddress", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal26getAttributeValueAsAddressEPKNS_9DWARFUnitEty",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal26getAttributeValueAsAddressEPKNS_9DWARFUnitEty")
  //</editor-fold>
  public long/*uint64_t*/ getAttributeValueAsAddress(/*const*/ DWARFUnit /*P*/ U, /*const*//*uint16_t*/char Attr, 
                            long/*uint64_t*/ FailValue) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getAttributeValueAsUnsignedConstant">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 98,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getAttributeValueAsUnsignedConstant", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal35getAttributeValueAsUnsignedConstantEPKNS_9DWARFUnitEty",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal35getAttributeValueAsUnsignedConstantEPKNS_9DWARFUnitEty")
  //</editor-fold>
  public long/*uint64_t*/ getAttributeValueAsUnsignedConstant(/*const*/ DWARFUnit /*P*/ U, 
                                     /*const*//*uint16_t*/char Attr, 
                                     long/*uint64_t*/ FailValue) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getAttributeValueAsReference">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 102,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getAttributeValueAsReference", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal28getAttributeValueAsReferenceEPKNS_9DWARFUnitEty",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal28getAttributeValueAsReferenceEPKNS_9DWARFUnitEty")
  //</editor-fold>
  public long/*uint64_t*/ getAttributeValueAsReference(/*const*/ DWARFUnit /*P*/ U, /*const*//*uint16_t*/char Attr, 
                              long/*uint64_t*/ FailValue) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getAttributeValueAsSectionOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 105,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getAttributeValueAsSectionOffset", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal32getAttributeValueAsSectionOffsetEPKNS_9DWARFUnitEty",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal32getAttributeValueAsSectionOffsetEPKNS_9DWARFUnitEty")
  //</editor-fold>
  public long/*uint64_t*/ getAttributeValueAsSectionOffset(/*const*/ DWARFUnit /*P*/ U, 
                                  /*const*//*uint16_t*/char Attr, 
                                  long/*uint64_t*/ FailValue) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getRangesBaseAttribute">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 109,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getRangesBaseAttribute", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal22getRangesBaseAttributeEPKNS_9DWARFUnitEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal22getRangesBaseAttributeEPKNS_9DWARFUnitEy")
  //</editor-fold>
  public long/*uint64_t*/ getRangesBaseAttribute(/*const*/ DWARFUnit /*P*/ U, long/*uint64_t*/ FailValue) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Retrieves DW_AT_low_pc and DW_AT_high_pc from CU.
  /// Returns true if both attributes are present.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getLowAndHighPC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 113,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getLowAndHighPC", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal15getLowAndHighPCEPKNS_9DWARFUnitERyS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal15getLowAndHighPCEPKNS_9DWARFUnitERyS4_")
  //</editor-fold>
  public boolean getLowAndHighPC(/*const*/ DWARFUnit /*P*/ U, final ulong$ref/*uint64_t &*/ LowPC, 
                 final ulong$ref/*uint64_t &*/ HighPC) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getAddressRanges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 116,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getAddressRanges", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal16getAddressRangesEPKNS_9DWARFUnitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal16getAddressRangesEPKNS_9DWARFUnitE")
  //</editor-fold>
  public std.vector<std.pairULongULong> getAddressRanges(/*const*/ DWARFUnit /*P*/ U) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::collectChildrenAddressRanges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 118,
   FQN="llvm::DWARFDebugInfoEntryMinimal::collectChildrenAddressRanges", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal28collectChildrenAddressRangesEPKNS_9DWARFUnitERSt6vectorISt4pairIyyESaIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal28collectChildrenAddressRangesEPKNS_9DWARFUnitERSt6vectorISt4pairIyyESaIS6_EE")
  //</editor-fold>
  public void collectChildrenAddressRanges(/*const*/ DWARFUnit /*P*/ U, 
                              final std.vector<std.pairULongULong> /*&*/ Ranges) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::addressRangeContainsAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 121,
   FQN="llvm::DWARFDebugInfoEntryMinimal::addressRangeContainsAddress", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal27addressRangeContainsAddressEPKNS_9DWARFUnitEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal27addressRangeContainsAddressEPKNS_9DWARFUnitEy")
  //</editor-fold>
  public boolean addressRangeContainsAddress(/*const*/ DWARFUnit /*P*/ U, 
                             /*const*/long/*uint64_t*/ Address) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// If a DIE represents a subprogram (or inlined subroutine),
  /// returns its mangled name (or short name, if mangled is missing).
  /// This name may be fetched from specification or abstract origin
  /// for this subprogram. Returns null if no name is found.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getSubroutineName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 128,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getSubroutineName", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal17getSubroutineNameEPKNS_9DWARFUnitENS_10DINameKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal17getSubroutineNameEPKNS_9DWARFUnitENS_10DINameKindE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSubroutineName(/*const*/ DWARFUnit /*P*/ U, DINameKind Kind) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Return the DIE name resolving DW_AT_sepcification or
  /// DW_AT_abstract_origin references if necessary.
  /// Returns null if no name is found.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 133,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getName", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal7getNameEPKNS_9DWARFUnitENS_10DINameKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal7getNameEPKNS_9DWARFUnitENS_10DINameKindE")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getName(/*const*/ DWARFUnit /*P*/ U, DINameKind Kind) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Retrieves values of DW_AT_call_file, DW_AT_call_line and
  /// DW_AT_call_column from DIE (or zeroes if they are missing).
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getCallerFrame">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 137,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getCallerFrame", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal14getCallerFrameEPKNS_9DWARFUnitERjS4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal14getCallerFrameEPKNS_9DWARFUnitERjS4_S4_")
  //</editor-fold>
  public void getCallerFrame(/*const*/ DWARFUnit /*P*/ U, final /*uint32_t &*/uint$ref CallFile, 
                final /*uint32_t &*/uint$ref CallLine, final /*uint32_t &*/uint$ref CallColumn) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get inlined chain for a given address, rooted at the current DIE.
  /// Returns empty chain if address is not contained in address range
  /// of current DIE.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugInfoEntryMinimal::getInlinedChainForAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugInfoEntry.h", line = 143,
   FQN="llvm::DWARFDebugInfoEntryMinimal::getInlinedChainForAddress", NM="_ZNK4llvm26DWARFDebugInfoEntryMinimal25getInlinedChainForAddressEPKNS_9DWARFUnitEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm26DWARFDebugInfoEntryMinimal25getInlinedChainForAddressEPKNS_9DWARFUnitEy")
  //</editor-fold>
  public DWARFDebugInfoEntryInlinedChain getInlinedChainForAddress(/*const*/ DWARFUnit /*P*/ U, /*const*/long/*uint64_t*/ Address) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "Offset=" + Offset // NOI18N
              + ", SiblingIdx=" + SiblingIdx // NOI18N
              + ", AbbrevDecl=" + AbbrevDecl; // NOI18N
  }
}
