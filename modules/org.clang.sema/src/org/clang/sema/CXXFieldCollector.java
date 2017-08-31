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

package org.clang.sema;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;


/// CXXFieldCollector - Used to keep track of CXXFieldDecls during parsing of
/// C++ classes.
//<editor-fold defaultstate="collapsed" desc="clang::CXXFieldCollector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CXXFieldCollector.h", line = 26,
 FQN="clang::CXXFieldCollector", NM="_ZN5clang17CXXFieldCollectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang17CXXFieldCollectorE")
//</editor-fold>
public class CXXFieldCollector implements Destructors.ClassWithDestructor {
  /// Fields - Contains all FieldDecls collected during parsing of a C++
  /// class. When a nested class is entered, its fields are appended to the
  /// fields of its parent class, when it is exited its fields are removed.
  private SmallVector<FieldDecl /*P*/ > Fields;
  
  /// FieldCount - Each entry represents the number of fields collected during
  /// the parsing of a C++ class. When a nested class is entered, a new field
  /// count is pushed, when it is exited, the field count is popped.
  private SmallVectorUInt FieldCount;

  // Example:
  //
  // class C {
  //   int x,y;
  //   class NC {
  //     int q;
  //     // At this point, Fields contains [x,y,q] decls and FieldCount contains
  //     // [2,1].
  //   };
  //   int z;
  //   // At this point, Fields contains [x,y,z] decls and FieldCount contains
  //   // [3].
  // };
  /*public:*/
  /// StartClass - Called by Sema::ActOnStartCXXClassDef.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFieldCollector::StartClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CXXFieldCollector.h", line = 53,
   FQN="clang::CXXFieldCollector::StartClass", NM="_ZN5clang17CXXFieldCollector10StartClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang17CXXFieldCollector10StartClassEv")
  //</editor-fold>
  public void StartClass() {
    FieldCount.push_back(0);
  }

  
  /// Add - Called by Sema::ActOnCXXMemberDeclarator.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFieldCollector::Add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CXXFieldCollector.h", line = 56,
   FQN="clang::CXXFieldCollector::Add", NM="_ZN5clang17CXXFieldCollector3AddEPNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang17CXXFieldCollector3AddEPNS_9FieldDeclE")
  //</editor-fold>
  public void Add(FieldDecl /*P*/ D) {
    Fields.push_back(D);
    FieldCount.ref$back().$assign(FieldCount.back() + 1);
  }

  
  /// getCurNumField - The number of fields added to the currently parsed class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFieldCollector::getCurNumFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CXXFieldCollector.h", line = 62,
   FQN="clang::CXXFieldCollector::getCurNumFields", NM="_ZNK5clang17CXXFieldCollector15getCurNumFieldsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK5clang17CXXFieldCollector15getCurNumFieldsEv")
  //</editor-fold>
  public /*size_t*/int getCurNumFields() /*const*/ {
    assert (!FieldCount.empty()) : "no currently-parsed class";
    return FieldCount.back$Const();
  }

  
  /// getCurFields - Pointer to array of fields added to the currently parsed
  /// class.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFieldCollector::getCurFields">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CXXFieldCollector.h", line = 69,
   FQN="clang::CXXFieldCollector::getCurFields", NM="_ZN5clang17CXXFieldCollector12getCurFieldsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang17CXXFieldCollector12getCurFieldsEv")
  //</editor-fold>
  public type$ptr<FieldDecl /*P*/ /*P*/> getCurFields() {
    return $AddrOf((Fields.end().$sub(getCurNumFields())));
  }

  
  /// FinishClass - Called by Sema::ActOnFinishCXXClassDef.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFieldCollector::FinishClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CXXFieldCollector.h", line = 72,
   FQN="clang::CXXFieldCollector::FinishClass", NM="_ZN5clang17CXXFieldCollector11FinishClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang17CXXFieldCollector11FinishClassEv")
  //</editor-fold>
  public void FinishClass() {
    Fields.resize(Fields.size() - getCurNumFields());
    FieldCount.pop_back();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFieldCollector::CXXFieldCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CXXFieldCollector.h", line = 26,
   FQN="clang::CXXFieldCollector::CXXFieldCollector", NM="_ZN5clang17CXXFieldCollectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang17CXXFieldCollectorC1Ev")
  //</editor-fold>
  public /*inline*/ CXXFieldCollector() {
    // : Fields(), FieldCount() 
    //START JInit
    this.Fields = new SmallVector<FieldDecl /*P*/ >(32, (FieldDecl /*P*/ )null);
    this.FieldCount = new SmallVectorUInt(4, 0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFieldCollector::~CXXFieldCollector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CXXFieldCollector.h", line = 26,
   FQN="clang::CXXFieldCollector::~CXXFieldCollector", NM="_ZN5clang17CXXFieldCollectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang17CXXFieldCollectorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FieldCount.$destroy();
    Fields.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Fields=" + Fields // NOI18N
              + ", FieldCount=" + FieldCount; // NOI18N
  }
}
