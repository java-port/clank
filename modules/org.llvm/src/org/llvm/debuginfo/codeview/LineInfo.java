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

package org.llvm.debuginfo.codeview;

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

//<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 22,
 FQN="llvm::codeview::LineInfo", NM="_ZN4llvm8codeview8LineInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8LineInfoE")
//</editor-fold>
public class LineInfo {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 24,
   FQN="llvm::codeview::LineInfo::(anonymous)", NM="_ZN4llvm8codeview8LineInfoE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8LineInfoE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : uint32_t {*/
    public static final /*uint32_t*/int AlwaysStepIntoLineNumber = 0xfeefee;
    public static final /*uint32_t*/int NeverStepIntoLineNumber = 0xf00f00;
  /*}*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 29,
   FQN="llvm::codeview::LineInfo::(anonymous)", NM="_ZN4llvm8codeview8LineInfoE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8LineInfoE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : int {*/
    public static final int EndLineDeltaShift = 24;
  /*}*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 31,
   FQN="llvm::codeview::LineInfo::(anonymous)", NM="_ZN4llvm8codeview8LineInfoE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8LineInfoE_Unnamed_enum2")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : uint32_t {*/
    public static final /*uint32_t*/int StartLineMask = 0x00ffffff;
    public static final /*uint32_t*/int EndLineDeltaMask = 0x7f000000;
    public static final /*uint32_t*/int StatementFlag = 0x80000000/*U*/;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::LineInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 37,
   FQN="llvm::codeview::LineInfo::LineInfo", NM="_ZN4llvm8codeview8LineInfoC1Ejjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8LineInfoC1Ejjb")
  //</editor-fold>
  public LineInfo(/*uint32_t*/int StartLine, /*uint32_t*/int EndLine, boolean IsStatement) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::LineInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 38,
   FQN="llvm::codeview::LineInfo::LineInfo", NM="_ZN4llvm8codeview8LineInfoC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8LineInfoC1Ej")
  //</editor-fold>
  public LineInfo(/*uint32_t*/int LineData) {
    // : LineData(LineData) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::getStartLine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 40,
   FQN="llvm::codeview::LineInfo::getStartLine", NM="_ZNK4llvm8codeview8LineInfo12getStartLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview8LineInfo12getStartLineEv")
  //</editor-fold>
  public /*uint32_t*/int getStartLine() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::getLineDelta">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 42,
   FQN="llvm::codeview::LineInfo::getLineDelta", NM="_ZNK4llvm8codeview8LineInfo12getLineDeltaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview8LineInfo12getLineDeltaEv")
  //</editor-fold>
  public /*uint32_t*/int getLineDelta() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::getEndLine">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 46,
   FQN="llvm::codeview::LineInfo::getEndLine", NM="_ZNK4llvm8codeview8LineInfo10getEndLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview8LineInfo10getEndLineEv")
  //</editor-fold>
  public /*uint32_t*/int getEndLine() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::isStatement">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 48,
   FQN="llvm::codeview::LineInfo::isStatement", NM="_ZNK4llvm8codeview8LineInfo11isStatementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview8LineInfo11isStatementEv")
  //</editor-fold>
  public boolean isStatement() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::getRawData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 50,
   FQN="llvm::codeview::LineInfo::getRawData", NM="_ZNK4llvm8codeview8LineInfo10getRawDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview8LineInfo10getRawDataEv")
  //</editor-fold>
  public /*uint32_t*/int getRawData() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::isAlwaysStepInto">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 52,
   FQN="llvm::codeview::LineInfo::isAlwaysStepInto", NM="_ZNK4llvm8codeview8LineInfo16isAlwaysStepIntoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview8LineInfo16isAlwaysStepIntoEv")
  //</editor-fold>
  public boolean isAlwaysStepInto() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::isNeverStepInto">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 56,
   FQN="llvm::codeview::LineInfo::isNeverStepInto", NM="_ZNK4llvm8codeview8LineInfo15isNeverStepIntoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZNK4llvm8codeview8LineInfo15isNeverStepIntoEv")
  //</editor-fold>
  public boolean isNeverStepInto() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private /*uint32_t*/int LineData;
  //<editor-fold defaultstate="collapsed" desc="llvm::codeview::LineInfo::LineInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/DebugInfo/CodeView/Line.h", line = 22,
   FQN="llvm::codeview::LineInfo::LineInfo", NM="_ZN4llvm8codeview8LineInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCCodeView.cpp -nm=_ZN4llvm8codeview8LineInfoC1ERKS1_")
  //</editor-fold>
  public /*inline*/ LineInfo(final /*const*/ LineInfo /*&*/ $Prm0) {
    // : LineData(.LineData) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "LineData=" + LineData; // NOI18N
  }
}
