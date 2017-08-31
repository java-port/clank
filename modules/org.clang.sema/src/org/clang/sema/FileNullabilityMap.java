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

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.llvm.DenseMapInfoFileID;


/// A mapping from file IDs to a record of whether we've seen nullability
/// information in that file.
//<editor-fold defaultstate="collapsed" desc="clang::FileNullabilityMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 234,
 FQN="clang::FileNullabilityMap", NM="_ZN5clang18FileNullabilityMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18FileNullabilityMapE")
//</editor-fold>
public class FileNullabilityMap implements Destructors.ClassWithDestructor {
  /// A mapping from file IDs to the nullability information for each file ID.
  private DenseMap<FileID, FileNullability> Map;
  
  /// A single-element cache based on the file ID.
  //<editor-fold defaultstate="collapsed" desc="clang::FileNullabilityMap::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 239,
   FQN="clang::FileNullabilityMap::(anonymous)", NM="_ZN5clang18FileNullabilityMapE_Unnamed_struct1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18FileNullabilityMapE_Unnamed_struct1")
  //</editor-fold>
  private static class/*struct*/ Unnamed_struct1 {
    public FileID File;
    public FileNullability Nullability;
    //<editor-fold defaultstate="collapsed" desc="clang::FileNullabilityMap::(anonymous struct)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 239,
     FQN="clang::FileNullabilityMap::(anonymous struct)::", NM="_ZN5clang18FileNullabilityMapUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18FileNullabilityMapUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_struct1() {
      // : File(), Nullability() 
      //START JInit
      this.File = new FileID();
      this.Nullability = new FileNullability();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "File=" + File // NOI18N
                + ", Nullability=" + Nullability; // NOI18N
    }
  };
  private Unnamed_struct1 Cache;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FileNullabilityMap::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 245,
   FQN="clang::FileNullabilityMap::operator[]", NM="_ZN5clang18FileNullabilityMapixENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18FileNullabilityMapixENS_6FileIDE")
  //</editor-fold>
  public FileNullability /*&*/ $at(FileID file) {
    // Check the single-element cache.
    if (file.$eq(Cache.File)) {
      return Cache.Nullability;
    }
    
    // It's not in the single-element cache; flush the cache if we have one.
    if (!Cache.File.isInvalid()) {
      Map.$at_T1$C$R(Cache.File).$assign(Cache.Nullability);
    }
    
    // Pull this entry into the cache.
    Cache.File.$assign(file);
    Cache.Nullability.$assign(Map.$at_T1$C$R(file));
    return Cache.Nullability;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileNullabilityMap::~FileNullabilityMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 234,
   FQN="clang::FileNullabilityMap::~FileNullabilityMap", NM="_ZN5clang18FileNullabilityMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18FileNullabilityMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Map.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FileNullabilityMap::FileNullabilityMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 234,
   FQN="clang::FileNullabilityMap::FileNullabilityMap", NM="_ZN5clang18FileNullabilityMapC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang18FileNullabilityMapC1Ev")
  //</editor-fold>
  public /*inline*/ FileNullabilityMap() {
    // : Map(), Cache() 
    //START JInit
    this.Map = new DenseMap<FileID, FileNullability>(DenseMapInfoFileID.$Info(), new FileNullability());
    this.Cache = new Unnamed_struct1();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Map=" + Map // NOI18N
              + ", Cache=" + Cache; // NOI18N
  }
}
