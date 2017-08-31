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

//<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugMacro">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugMacro.h", line = 21,
 FQN="llvm::DWARFDebugMacro", NM="_ZN4llvm15DWARFDebugMacroE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm15DWARFDebugMacroE")
//</editor-fold>
public class DWARFDebugMacro implements Destructors.ClassWithDestructor {
  /// A single macro entry within a macro list.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugMacro::Entry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugMacro.h", line = 23,
   FQN="llvm::DWARFDebugMacro::Entry", NM="_ZN4llvm15DWARFDebugMacro5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm15DWARFDebugMacro5EntryE")
  //</editor-fold>
  private static class/*struct*/ Entry {
    /// The type of the macro entry.
    public /*uint32_t*/int Type;
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugMacro::Entry::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugMacro.h", line = 26,
     FQN="llvm::DWARFDebugMacro::Entry::(anonymous)", NM="_ZN4llvm15DWARFDebugMacro5EntryE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm15DWARFDebugMacro5EntryE_Unnamed_union1")
    //</editor-fold>
    public static class/*union*/ Unnamed_union1 {
      /// The source line where the macro is defined.
      public long/*uint64_t*/ Line;
      /// Vendor extension constant value.
      public long/*uint64_t*/ ExtConstant;
      
      @Override public String toString() {
        return "" + "Line=" + Line // NOI18N
                  + ", ExtConstant=" + ExtConstant; // NOI18N
      }
    };
    public Unnamed_union1 Unnamed_field1 = new Unnamed_union1();
    //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugMacro::Entry::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugMacro.h", line = 33,
     FQN="llvm::DWARFDebugMacro::Entry::(anonymous)", NM="_ZN4llvm15DWARFDebugMacro5EntryE_Unnamed_union2",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm15DWARFDebugMacro5EntryE_Unnamed_union2")
    //</editor-fold>
    public static class/*union*/ Unnamed_union2 {
      /// The string (name, value) of the macro entry.
      public /*const*/char$ptr/*char P*/ MacroStr;
      // An unsigned integer indicating the identity of the source file.
      public long/*uint64_t*/ File;
      /// Vendor extension string.
      public /*const*/char$ptr/*char P*/ ExtStr;
      
      @Override public String toString() {
        return "" + "MacroStr=" + MacroStr // NOI18N
                  + ", File=" + File // NOI18N
                  + ", ExtStr=" + ExtStr; // NOI18N
      }
    };
    public Unnamed_union2 Unnamed_field2 = new Unnamed_union2();
    
    @Override public String toString() {
      return "" + "Type=" + Type // NOI18N
                + ", Unnamed_field1=" + Unnamed_field1 // NOI18N
                + ", Unnamed_field2=" + Unnamed_field2; // NOI18N
    }
  };
  
  // JAVA: typedef SmallVector<Entry, 4> MacroList
//  public final class MacroList extends SmallVector<Entry>{ };
  
  /// A list of all the macro entries in the debug_macinfo section.
  private SmallVector<Entry> Macros;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugMacro::DWARFDebugMacro">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugMacro.h", line = 49,
   FQN="llvm::DWARFDebugMacro::DWARFDebugMacro", NM="_ZN4llvm15DWARFDebugMacroC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm15DWARFDebugMacroC1Ev")
  //</editor-fold>
  public DWARFDebugMacro() {
    // : Macros() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Print the macro list found within the debug_macinfo section.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugMacro::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugMacro.h", line = 51,
   FQN="llvm::DWARFDebugMacro::dump", NM="_ZNK4llvm15DWARFDebugMacro4dumpERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZNK4llvm15DWARFDebugMacro4dumpERNS_11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  /// Parse the debug_macinfo section accessible via the 'data' parameter.
  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugMacro::parse">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugMacro.h", line = 53,
   FQN="llvm::DWARFDebugMacro::parse", NM="_ZN4llvm15DWARFDebugMacro5parseENS_13DataExtractorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm15DWARFDebugMacro5parseENS_13DataExtractorE")
  //</editor-fold>
  public void parse(DataExtractor data) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DWARFDebugMacro::~DWARFDebugMacro">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/DWARF/DWARFDebugMacro.h", line = 21,
   FQN="llvm::DWARFDebugMacro::~DWARFDebugMacro", NM="_ZN4llvm15DWARFDebugMacroD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ObjectFilePCHContainerOperations.cpp -nm=_ZN4llvm15DWARFDebugMacroD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Macros=" + Macros; // NOI18N
  }
}
