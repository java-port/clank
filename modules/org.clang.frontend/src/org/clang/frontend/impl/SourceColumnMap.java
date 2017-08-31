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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.frontend.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assert msg*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 254,
 FQN="(anonymous namespace)::SourceColumnMap", NM="_ZN12_GLOBAL__N_115SourceColumnMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN12_GLOBAL__N_115SourceColumnMapE")
//</editor-fold>
public class/*struct*/ SourceColumnMap implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap::SourceColumnMap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 255,
   FQN="(anonymous namespace)::SourceColumnMap::SourceColumnMap", NM="_ZN12_GLOBAL__N_115SourceColumnMapC1EN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN12_GLOBAL__N_115SourceColumnMapC1EN4llvm9StringRefEj")
  //</editor-fold>
  public SourceColumnMap(StringRef SourceLine, /*uint*/int TabStop) {
    // : m_SourceLine(SourceLine.operator basic_string()), m_byteToColumn(), m_columnToByte() 
    //START JInit
    this.m_SourceLine = SourceLine.$string();
    this.m_byteToColumn = new SmallVectorInt/*200*/(200);
    this.m_columnToByte = new SmallVectorInt/*200*/(200);
    //END JInit
    
    /*::*/TextDiagnosticStatics.byteToColumn(/*NO_COPY*/SourceLine, TabStop, m_byteToColumn);
    /*::*/TextDiagnosticStatics.columnToByte(/*NO_COPY*/SourceLine, TabStop, m_columnToByte);
    assert (m_byteToColumn.size() == SourceLine.size() + 1);
    assert ($less_uint(0, m_byteToColumn.size()) && $less_uint(0, m_columnToByte.size()));
    assert (m_byteToColumn.size() == ((/*static_cast*//*uint*/int)(m_columnToByte.back() + 1)));
    assert (((/*static_cast*//*uint*/int)(m_byteToColumn.back() + 1)) == m_columnToByte.size());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap::columns">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 268,
   FQN="(anonymous namespace)::SourceColumnMap::columns", NM="_ZNK12_GLOBAL__N_115SourceColumnMap7columnsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_115SourceColumnMap7columnsEv")
  //</editor-fold>
  public int columns() /*const*/ {
    return m_byteToColumn.back$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap::bytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 269,
   FQN="(anonymous namespace)::SourceColumnMap::bytes", NM="_ZNK12_GLOBAL__N_115SourceColumnMap5bytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_115SourceColumnMap5bytesEv")
  //</editor-fold>
  public int bytes() /*const*/ {
    return m_columnToByte.back$Const();
  }

  
  /// \brief Map a byte to the column which it is at the start of, or return -1
  /// if it is not at the start of a column (for a UTF-8 trailing byte).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap::byteToColumn">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 273,
   FQN="(anonymous namespace)::SourceColumnMap::byteToColumn", NM="_ZNK12_GLOBAL__N_115SourceColumnMap12byteToColumnEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_115SourceColumnMap12byteToColumnEi")
  //</editor-fold>
  public int byteToColumn(int n) /*const*/ {
    assert (0 <= n && n < ((/*static_cast*/int)(m_byteToColumn.size()))) : "" + n + " is out of range " + m_byteToColumn.size();
    return m_byteToColumn.$at$Const(n);
  }

  
  /// \brief Map a byte to the first column which contains it.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap::byteToContainingColumn">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 279,
   FQN="(anonymous namespace)::SourceColumnMap::byteToContainingColumn", NM="_ZNK12_GLOBAL__N_115SourceColumnMap22byteToContainingColumnEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_115SourceColumnMap22byteToContainingColumnEi")
  //</editor-fold>
  public int byteToContainingColumn(int N) /*const*/ {
    assert (0 <= N && N < ((/*static_cast*/int)(m_byteToColumn.size()))) : "" + N + " is out of range " + m_byteToColumn.size();
    while (m_byteToColumn.$at$Const(N) == -1) {
      --N;
    }
    return m_byteToColumn.$at$Const(N);
  }

  
  /// \brief Map a column to the byte which starts the column, or return -1 if
  /// the column the second or subsequent column of an expanded tab or similar
  /// multi-column entity.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap::columnToByte">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 289,
   FQN="(anonymous namespace)::SourceColumnMap::columnToByte", NM="_ZNK12_GLOBAL__N_115SourceColumnMap12columnToByteEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_115SourceColumnMap12columnToByteEi")
  //</editor-fold>
  public int columnToByte(int n) /*const*/ {
    assert (0 <= n && n < ((/*static_cast*/int)(m_columnToByte.size()))) : "" + n + " is out of range " + m_byteToColumn.size();
    return m_columnToByte.$at$Const(n);
  }

  
  /// \brief Map from a byte index to the next byte which starts a column.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap::startOfNextColumn">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 295,
   FQN="(anonymous namespace)::SourceColumnMap::startOfNextColumn", NM="_ZNK12_GLOBAL__N_115SourceColumnMap17startOfNextColumnEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_115SourceColumnMap17startOfNextColumnEi")
  //</editor-fold>
  public int startOfNextColumn(int N) /*const*/ {
    assert (0 <= N && N < ((/*static_cast*/int)(m_byteToColumn.size() - 1))) : "" + N + " is out of range " + m_byteToColumn.size();
    while (byteToColumn(++N) == -1) {
    }
    return N;
  }

  
  /// \brief Map from a byte index to the previous byte which starts a column.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap::startOfPreviousColumn">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assert msg*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 302,
   FQN="(anonymous namespace)::SourceColumnMap::startOfPreviousColumn", NM="_ZNK12_GLOBAL__N_115SourceColumnMap21startOfPreviousColumnEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_115SourceColumnMap21startOfPreviousColumnEi")
  //</editor-fold>
  public int startOfPreviousColumn(int N) /*const*/ {
    assert (0 < N && N < ((/*static_cast*/int)(m_byteToColumn.size()))) : "" + N + " is out of range " + m_byteToColumn.size();
    while (byteToColumn(--N) == -1) {
    }
    return N;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap::getSourceLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 308,
   FQN="(anonymous namespace)::SourceColumnMap::getSourceLine", NM="_ZNK12_GLOBAL__N_115SourceColumnMap13getSourceLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZNK12_GLOBAL__N_115SourceColumnMap13getSourceLineEv")
  //</editor-fold>
  public StringRef getSourceLine() /*const*/ {
    return new StringRef(m_SourceLine);
  }

/*private:*/
  private /*const*/std.string m_SourceLine;
  private SmallVectorInt/*200*/ m_byteToColumn;
  private SmallVectorInt/*200*/ m_columnToByte;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceColumnMap::~SourceColumnMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp", line = 254,
   FQN="(anonymous namespace)::SourceColumnMap::~SourceColumnMap", NM="_ZN12_GLOBAL__N_115SourceColumnMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnostic.cpp -nm=_ZN12_GLOBAL__N_115SourceColumnMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    m_columnToByte.$destroy();
    m_byteToColumn.$destroy();
    m_SourceLine.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "m_SourceLine=" + m_SourceLine // NOI18N
              + ", m_byteToColumn=" + m_byteToColumn // NOI18N
              + ", m_columnToByte=" + m_columnToByte; // NOI18N
  }
}
