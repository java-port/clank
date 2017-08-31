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

//<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 21,
 FQN="llvm::DWARFDebugAranges", NM="_ZN4llvm17DWARFDebugArangesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugArangesE")
//</editor-fold>
public class DWARFDebugAranges implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::generate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 23,
   FQN="llvm::DWARFDebugAranges::generate", NM="_ZN4llvm17DWARFDebugAranges8generateEPNS_12DWARFContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugAranges8generateEPNS_12DWARFContextE")
  //</editor-fold>
  public void generate(DWARFContext /*P*/ CTX) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::findAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 24,
   FQN="llvm::DWARFDebugAranges::findAddress", NM="_ZNK4llvm17DWARFDebugAranges11findAddressEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm17DWARFDebugAranges11findAddressEy")
  //</editor-fold>
  public /*uint32_t*/int findAddress(long/*uint64_t*/ Address) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::clear">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 27,
   FQN="llvm::DWARFDebugAranges::clear", NM="_ZN4llvm17DWARFDebugAranges5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugAranges5clearEv")
  //</editor-fold>
  private void clear() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::extract">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 28,
   FQN="llvm::DWARFDebugAranges::extract", NM="_ZN4llvm17DWARFDebugAranges7extractENS_13DataExtractorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugAranges7extractENS_13DataExtractorE")
  //</editor-fold>
  private void extract(DataExtractor DebugArangesData) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // Call appendRange multiple times and then call construct.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::appendRange">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 31,
   FQN="llvm::DWARFDebugAranges::appendRange", NM="_ZN4llvm17DWARFDebugAranges11appendRangeEjyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugAranges11appendRangeEjyy")
  //</editor-fold>
  private void appendRange(/*uint32_t*/int CUOffset, long/*uint64_t*/ LowPC, long/*uint64_t*/ HighPC) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::construct">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 32,
   FQN="llvm::DWARFDebugAranges::construct", NM="_ZN4llvm17DWARFDebugAranges9constructEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugAranges9constructEv")
  //</editor-fold>
  private void construct() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::Range">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 34,
   FQN="llvm::DWARFDebugAranges::Range", NM="_ZN4llvm17DWARFDebugAranges5RangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugAranges5RangeE")
  //</editor-fold>
  private static class/*struct*/ Range {
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::Range::Range">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 35,
     FQN="llvm::DWARFDebugAranges::Range::Range", NM="_ZN4llvm17DWARFDebugAranges5RangeC1Eyyj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugAranges5RangeC1Eyyj")
    //</editor-fold>
    public /*explicit*/ Range() {
      this(-1L/*ULL*/, -1L/*ULL*/, 
        -1/*U*/);
    }
    public /*explicit*/ Range(long/*uint64_t*/ LowPC/*= -1ULLULL*/) {
      this(LowPC, -1L/*ULL*/, 
        -1/*U*/);
    }
    public /*explicit*/ Range(long/*uint64_t*/ LowPC/*= -1ULLULL*/, long/*uint64_t*/ HighPC/*= -1ULLULL*/) {
      this(LowPC, HighPC, 
        -1/*U*/);
    }
    public /*explicit*/ Range(long/*uint64_t*/ LowPC/*= -1ULLULL*/, long/*uint64_t*/ HighPC/*= -1ULLULL*/, 
        /*uint32_t*/int CUOffset/*= -1UU*/) {
      // : LowPC(LowPC), Length(HighPC - LowPC), CUOffset(CUOffset) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::Range::setHighPC">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 39,
     FQN="llvm::DWARFDebugAranges::Range::setHighPC", NM="_ZN4llvm17DWARFDebugAranges5Range9setHighPCEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugAranges5Range9setHighPCEy")
    //</editor-fold>
    public void setHighPC(long/*uint64_t*/ HighPC) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::Range::HighPC">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 45,
     FQN="llvm::DWARFDebugAranges::Range::HighPC", NM="_ZNK4llvm17DWARFDebugAranges5Range6HighPCEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm17DWARFDebugAranges5Range6HighPCEv")
    //</editor-fold>
    public long/*uint64_t*/ HighPC() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::Range::containsAddress">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 51,
     FQN="llvm::DWARFDebugAranges::Range::containsAddress", NM="_ZNK4llvm17DWARFDebugAranges5Range15containsAddressEy",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm17DWARFDebugAranges5Range15containsAddressEy")
    //</editor-fold>
    public boolean containsAddress(long/*uint64_t*/ Address) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::Range::operator<">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 54,
     FQN="llvm::DWARFDebugAranges::Range::operator<", NM="_ZNK4llvm17DWARFDebugAranges5RangeltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm17DWARFDebugAranges5RangeltERKS1_")
    //</editor-fold>
    public boolean $less(final /*const*/ Range /*&*/ other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    public long/*uint64_t*/ LowPC; // Start of address range.
    public /*uint32_t*/int Length; // End of address range (not including this address).
    public /*uint32_t*/int CUOffset; // Offset of the compile unit or die.
    
    @Override public String toString() {
      return "" + "LowPC=" + LowPC // NOI18N
                + ", Length=" + Length // NOI18N
                + ", CUOffset=" + CUOffset; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::RangeEndpoint">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 63,
   FQN="llvm::DWARFDebugAranges::RangeEndpoint", NM="_ZN4llvm17DWARFDebugAranges13RangeEndpointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugAranges13RangeEndpointE")
  //</editor-fold>
  private static class/*struct*/ RangeEndpoint {
    public long/*uint64_t*/ Address;
    public /*uint32_t*/int CUOffset;
    public boolean IsRangeStart;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::RangeEndpoint::RangeEndpoint">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 68,
     FQN="llvm::DWARFDebugAranges::RangeEndpoint::RangeEndpoint", NM="_ZN4llvm17DWARFDebugAranges13RangeEndpointC1Eyjb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugAranges13RangeEndpointC1Eyjb")
    //</editor-fold>
    public RangeEndpoint(long/*uint64_t*/ Address, /*uint32_t*/int CUOffset, boolean IsRangeStart) {
      // : Address(Address), CUOffset(CUOffset), IsRangeStart(IsRangeStart) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::RangeEndpoint::operator<">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 71,
     FQN="llvm::DWARFDebugAranges::RangeEndpoint::operator<", NM="_ZNK4llvm17DWARFDebugAranges13RangeEndpointltERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm17DWARFDebugAranges13RangeEndpointltERKS1_")
    //</editor-fold>
    public boolean $less(final /*const*/ RangeEndpoint /*&*/ Other) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Address=" + Address // NOI18N
                + ", CUOffset=" + CUOffset // NOI18N
                + ", IsRangeStart=" + IsRangeStart; // NOI18N
    }
  };
  
  // JAVA: typedef std::vector<Range> RangeColl
//  public final class RangeColl extends std.vector<Range>{ };
  // JAVA: typedef RangeColl::const_iterator RangeCollIterator
//  public final class RangeCollIterator extends std.vector.iterator</*const*/ Range /*P*/ >{ };
  
  private std.vector<RangeEndpoint> Endpoints;
  private std.vector<Range> Aranges;
  private DenseSetUInt ParsedCUOffsets;
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugAranges::~DWARFDebugAranges">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugAranges.h", line = 21,
   FQN="llvm::DWARFDebugAranges::~DWARFDebugAranges", NM="_ZN4llvm17DWARFDebugArangesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm17DWARFDebugArangesD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Endpoints=" + Endpoints // NOI18N
              + ", Aranges=" + Aranges // NOI18N
              + ", ParsedCUOffsets=" + ParsedCUOffsets; // NOI18N
  }
}
